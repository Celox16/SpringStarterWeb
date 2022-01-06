package com.fastcampus.service;

import com.fastcampus.domain.Board;
import com.fastcampus.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    // 스프링부트가 만들어준 BoardRepository 타입의 객체를 의존성 주입한다.
    @Autowired
    private BoardRepository boardRepository;

    // 글 등록
    @Override
    public void insertBoard(Board board) { boardRepository.save(board); }

    // 글 수정
    @Override
    public void updateBoard(Board board) {
        // 수정할 엔티티를 검색한다.
        Board findBoard = boardRepository.findById(board.getSeq()).get();

        // 검색한 엔티티를 수정하고 수정한 엔티티를 다시 저장한다.
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepository.save(board);
    }

    // 글 삭제
    @Override
    public void deleteBoard(Board board) { boardRepository.deleteById(board.getSeq()); }

    // 글 상세 조회
    @Override
    public Board getBoard(Board board) { return boardRepository.findById(board.getSeq()).get(); }

    // 글 목록 조회
    @Override
    public List<Board> getBoardList(Board board) { return (List<Board>) boardRepository.findAll(); }
}
