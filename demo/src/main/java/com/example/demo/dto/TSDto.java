package com.example.demo.dto;

import com.example.demo.entity.Article;
import com.example.demo.entity.TS;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
public class TSDto {

    private String visited;
    private String date;
    private String sLength;
    private String sTrCode;
    private String sRpCode;
    private String sSeq;
    private String sDataCnt;
    private String sMsgGb;
    private String sOrderNo ;
    private String sIssueCode;
    private String sAcctNo;
    private String sTrdNo;
    private String sTrdPrice;
    private String sTrdQty;
    private String sTrdType;
    private String sTrdTime;
    private String sNearTrdPrice;
    private String sFarTrdPrice;
    private String sSide;
    private String sBookCode;
    private String sFiller;
    private String sPurpose;
    private String sBalanceType;
    private String sdontknow;

    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public TS toEntity(){
        return new TS(null,visited, date, sLength, sTrCode, sRpCode,
                sSeq,sDataCnt,sMsgGb,sOrderNo,sIssueCode,sAcctNo,sTrdNo,sTrdPrice,sTrdQty,
                sTrdType, sTrdTime, sNearTrdPrice, sFarTrdPrice, sSide, sBookCode, sFiller,
                sPurpose,sBalanceType, sdontknow);
    }


}
