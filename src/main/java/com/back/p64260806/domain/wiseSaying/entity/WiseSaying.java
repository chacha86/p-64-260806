package com.back.p64260806.domain.wiseSaying.entity;

import com.back.p64260806.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@NoArgsConstructor // 매개변수 없는 기본 생성자 => 외부 라이브러리
@AllArgsConstructor // 모든 인스턴스 변수에 대한 매개변수를 받는 생성자
@EqualsAndHashCode
@ToString
@Entity
public class WiseSaying extends BaseEntity {
    private String content;
    private String author;
}