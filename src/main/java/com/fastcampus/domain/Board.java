package com.fastcampus.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
// JPA를 위한 어노테이션
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;

    @Column(updatable = false)
    private String writer;
    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date regdate = new Date();

    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private Long cnt = 0L;

    @Transient
    private String searchCondition;

    @Transient
    private String searchKeyword;
}
