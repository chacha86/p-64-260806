package com.back.p64260806.domain.wiseSaying.controller;

import com.back.p64260806.domain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WiseSayingController {

    private List<WiseSaying> wiseSayings = new ArrayList<>() {{
        add(new WiseSaying(1, "명언1", "작가1"));
        add(new WiseSaying(2, "명언2", "작가2"));
        add(new WiseSaying(3, "명언3", "작가3"));
        add(new WiseSaying(4, "명언4", "작가4"));
        add(new WiseSaying(5, "명언5", "작가5"));
    }};

    private int lastId = 5;

    @GetMapping("/wiseSaying/write")
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

        WiseSaying wiseSaying = new WiseSaying(++lastId, content, author);
        wiseSayings.add(wiseSaying);

        return "%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId());
    }

    @GetMapping("/wiseSaying/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {

        WiseSaying wiseSaying = findById(id);
        wiseSayings.remove(wiseSaying);

        return "%d번 명언이 삭제되었습니다".formatted(id);
    }

    @GetMapping("/wiseSaying/modify/{id}")
    @ResponseBody
    public String modify(
            @PathVariable int id,
            @RequestParam(defaultValue = "기본값") String content,
            @RequestParam(defaultValue = "기본값") String author
    ) {

        WiseSaying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        return "%d번 명언이 수정되었습니다.".formatted(wiseSaying.getId());
    }

    private WiseSaying findById(int id) {
        Optional<WiseSaying> wiseSaying = wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst();

        if(wiseSaying.isEmpty()) {
            throw new RuntimeException("%d번 명언은 존재하지 않습니다.".formatted(id));
        }

        wiseSayings.remove(wiseSaying.get());
        return wiseSaying.get();
    }
}

