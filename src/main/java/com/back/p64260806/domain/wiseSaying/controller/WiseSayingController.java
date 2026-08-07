package com.back.p64260806.domain.wiseSaying.controller;

import com.back.p64260806.domain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WiseSayingController {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    @GetMapping("/write")
    @ResponseBody
    public String actionAdd(String content, String author) {

//        우리 TDD 코드를 그대로 옮기되 sout을 web으로만 바꿈
//          -> 비즈니스 로직은 언제나 유효
//          -> 스프링부트 웹 환경에서는 고객에게 ?키=밸류 형식으로 데이터를 받는다.
//           -> 스프링부트 웹 환경에서는 문제가 생기면 return이 아닌 throw new로 예외를 던진다.

        // 예외 사항 => 작가 내용이 비어있음
        if(author.isEmpty()) {
//            throw new RuntimeException("작가 내용이 비어있습니다.");
            throw new IllegalArgumentException("작가 내용이 비어있습니다.");
        }

        if(content.isEmpty()) {
            throw new IllegalArgumentException("명언 내용이 비어있습니다.");
        }

        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);

        return "%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId());
    }
}
