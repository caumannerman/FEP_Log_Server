package com.example.demo.repository;


import com.example.demo.entity.Article;
import com.example.demo.entity.TS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface TSRepository extends CrudRepository<TS, Long> {

    //API 1번. parameter로 받은 bookcode와 date가 일치하고 visited = "0"(아직 안 받은 로그)인 row 중 id가 가장 작은 것(시간상 가장 오래된 로그) 하나만 return
    @Query(value = "SELECT * FROM ts WHERE date = ?1 and s_book_code = ?2 and visited = '0' ORDER BY id ASC LIMIT 1", nativeQuery = true)
    TS returnonets( String date, String bookcode);


    // API 2번. 1번 api를 받고, id와 visited="1"만 json에 넣어 PATCH해주는 요청
    // 사실 visited라는 것은 Table을 별도로 두어야 맞지만( 사람1이 visited한 것이 사람2에게 영향 주면 안되므로) 여기서는 그냥 한 사람만 사용한다 침..


    // API 3번. parameter로 받은 bookcode와 date가 일치하고 visited = "1"(받은 로그)인 row 30개를 return
    @Query(value = "SELECT * FROM ts WHERE date = ?1 and s_book_code = ?2 and visited = '1' ORDER BY id DESC LIMIT 30", nativeQuery = true)
    ArrayList<TS> get_visited_logs(String date, String bookcode);
}
