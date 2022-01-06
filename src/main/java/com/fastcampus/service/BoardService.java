package com.fastcampus.service;

import com.fastcampus.domain.Board;

import java.util.List;

public interface BoardService {

    // 글 등록
    void insertBoard(Board board);

    // 글 수정
    void updateBoard(Board board);

    // 글 삭제
    void deleteBoard(Board board);

    // 글 상세 조회
    Board getBoard(Board board);

    // 글 목록 조회
    List<Board> getBoardList(Board board);
}
