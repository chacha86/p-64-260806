package com.back.p64260806.domain.wiseSaying.controller;

import com.back.p64260806.domain.wiseSaying.entity.WiseSaying;

public class WiseSayingController {

    public void actionAdd() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(saying, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }
}
