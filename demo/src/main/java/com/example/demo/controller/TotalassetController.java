package com.example.demo.controller;

import com.example.demo.entity.Totalasset;
import com.example.demo.repository.TotalassetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class TotalassetController {

    @Autowired
    private TotalassetRepository totalassetRepository;

    //API 4번. API1번에서 호출한, 방문하지 않았던 로그 json을 사용해서 북코드, 날짜를 PK로 하여 매도수량, 매도금액 PATCH해주면 됨.
    // 현물 ,선물 따로따로 해야함. issuecode가 다르므로. bookcode 말고 issuecode로!
    @PatchMapping("/api/v1/patch/totalasset")
    public ResponseEntity<Totalasset> update(@RequestParam String issuecode, @RequestParam String date,@RequestParam String quantity,
                                             @RequestParam String price,@RequestParam String side){

        //대상 엔티티 조회
        Totalasset target = totalassetRepository.get_oneasset(date, issuecode);

        //변경할 부분 변경..
        // price, quantity, side로 처리..
        //string으로 받아왔으니 각각 int, Long으로 바꿔줌. 뒷쪽 계산을 용이하게 하기 위해.
        int now_quantity = Integer.parseInt(quantity);
        Long now_price = Long.parseLong(price);
        // side == "1"면 매도, side == "2"이면 매수

        // 1.현재 체결된 것과 원래의 포지션이 방향성이 같다
        if( target.getQuantity() == 0 || (target.getQuantity() > 0 && side.equals("2")) || (target.getQuantity() < 0 && side.equals("1")) ){
            //원래의 가격
            Long original_sum = target.getPricesum();
            //원래의 수량
            int original_quantity = target.getQuantity();


            // 원래 수량에 방금 체결된 수량을 추가해줌.
            // 숏 방향이면 빼줌.
            if (original_quantity < 0){
                target.setQuantity(original_quantity - now_quantity);
                // 원래 가격에 방금 체결된 가격을 추가해줌
                target.setPricesum(original_sum - ((Long)now_price) * now_quantity);
            }//롱 방향이었으면 똑같이 롱쪽으로.
            else if (original_quantity > 0){
                target.setQuantity(original_quantity + now_quantity);
                // 원래 가격에 방금 체결된 가격을 추가해줌
                target.setPricesum(original_sum + ((Long)now_price) * now_quantity);
            }//0이었으면 side방향쪽으로 갯수 늘려줘야한다.
            else{
                //매도 포지션
                if(side.equals("1")){
                    target.setQuantity( -now_quantity);
                    // 원래 가격에 방금 체결된 가격을 추가해줌
                    target.setPricesum(-((Long)now_price) * now_quantity);
                }
                else{// side.equals("2") -> 매수
                    target.setQuantity(now_quantity);
                    // 원래 가격에 방금 체결된 가격을 추가해줌
                    target.setPricesum(((Long)now_price) * now_quantity);
                }
            }
        }
        // 2. 현재 포지션과 체결 포지션 방향이 다르다.
        //수량, 가격 바꿔주고, realprofit(실현손익)도 변경해주어야한다.
        else{
            //원래의 가격
            Long original_sum = target.getPricesum();
            //원래의 수량
            int original_quantity = target.getQuantity();
            //원래의 실현 손익
            Long original_realprofit = target.getRealprofit();

            // 원래 포지션 쪽으로 수량이 남는 경우. + 포지션이 완전 청산되는 경우
            //수량, 가격 바꿔주고, realprofit(실현손익)도 변경해주어야한다.
            if(Math.abs(original_quantity) >= Math.abs(now_quantity)){
                //원래 롱포지션, 합쳐도 롱포지션
                if(original_quantity > 0){
                    // 꼭 실현손익 -> 가격합 -> 수량 순으로 변경해야 영향 안줌.
                    // 실현 손익 변경
                    // 지금의 평단에서 원래의 평단을 빼고 지금의 수량(상쇄된 수량만큼) 곱해서 원래 실현손익에 더해줌.
                    target.setRealprofit( original_realprofit + (now_price - (Long)(original_sum / original_quantity)) * now_quantity );
                    //가격 변경 ( 원래의 평단은 유지해야 실현손익에 손익을 이동시켜주는 의미가 있다. 평단은 유지한다)
                    target.setPricesum(original_sum * (original_quantity - now_quantity) / original_quantity);
                    //수량 변경
                    target.setQuantity(original_quantity - now_quantity);

                }
                // 원래 숏포지션, 합쳐도 숏포지션
                else{
                    // 꼭 실현손익 -> 가격합 -> 수량 순으로 변경해야 영향 안줌.
                    // 실현 손익 변경
                    // 원래의 매도평단에서 지금의 매수평단을 빼고 지금의 수량(상쇄된 수량만큼) 곱해서 원래 실현손익에 더해줌.
                    target.setRealprofit( original_realprofit + ((Long)(original_sum / original_quantity) - now_price) * now_quantity );
                    //가격 변경
                    target.setPricesum(original_sum * (-original_quantity - now_quantity) / (-original_quantity));
                    //수량 변경
                    target.setQuantity(original_quantity + now_quantity);
                }
            }
            // 포지션이 역전되는 경우
            // 수량, 가격 바꿔주고, realprofit(실현손익)도 변경해주어야한다.
            else{
                //원래 롱포지션, 합치면 숏포지션
                if(original_quantity > 0){
                    // 꼭 실현손익 -> 가격합 -> 수량 순으로 변경해야 영향 안줌.
                    // 실현 손익 변경
                    // 원래 롱 포지션이었으니까, 매수 금액인 original_sum을 다 빼주고, 매도 평단에 원래 가지고있던(상쇄된) 수량 곱해서 더해줌
                    target.setRealprofit( original_realprofit - original_sum + now_price * original_quantity);
                    //가격 변경
                    // 포지션 역전되었으니, 새 평단인 now_price에 새롭게 남은 수량 곱해주면됨.
                    target.setPricesum( (now_quantity - original_quantity) * now_price);
                    //수량 변경 양수에서 음수로!
                    target.setQuantity(original_quantity - now_quantity);
                }
                // 원래 숏포지션, 합치면 롱포지션
                else{
                    // 꼭 실현손익 -> 가격합 -> 수량 순으로 변경해야 영향 안줌.
                    // 실현 손익 변경
                    // 원래 숏 포지션이었으니까, 매도 금액인 original_sum을 다 더해주고, 매수 평단에 원래 가지고있던(상쇄된) 수량 곱해서 뺴줌
                    target.setRealprofit( original_realprofit + original_sum - now_price * original_quantity);
                    //가격 변경
                    // 포지션 역전되었으니, 새 평단인 now_price에 새롭게 남은 수량 곱해주면됨.
                    target.setPricesum( (now_quantity + original_quantity) * now_price);
                    //수량 변경 음수에서 양수로!
                    target.setQuantity(original_quantity + now_quantity);
                }
            }
        }


        //target.setBuyquantity(Integer.parseInt(buyquantity));

        // 업데이트 및 정상 응답
        Totalasset updated = totalassetRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);

    }

    //API 5번. 북코드 + 날짜 (합성 PK)를 이용하여 Table row 단순 GET (현물, 선물 두개를 리스트로 보냄)
    @GetMapping("/api/v1/get/totalasset")
    public List<Totalasset> ts_two(@RequestParam String bookcode, @RequestParam String date){
        return totalassetRepository.get_bookasset(date, bookcode);
    }
}
