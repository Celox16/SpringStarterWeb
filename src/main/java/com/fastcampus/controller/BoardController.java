package com.fastcampus.controller;

import com.fastcampus.domain.Board;
import com.fastcampus.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @Autowired // 의존성 주입
    private BoardService boardService;

    @RequestMapping("/")
    public String index() { return "forward:index.jsp"; }

    @RequestMapping("/board/insertBoardView")
    public String insertBoardView() { return "insertBoard"; }

    @RequestMapping("/board/inserBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "forward:/board/getBoardList";
    }

    @RequestMapping("/board/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:/board/getBoardList";
    }

    @RequestMapping("/board/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:/board/getBoardList";
    }

    @RequestMapping("/board/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getBaord"; // jsp파일이므로 /board를 안붙임
    }

    @RequestMapping("/board/geBoardList")
    public String getBoardList(Board board, Model model) {
        if(board.getSearchCondition() == null) board.setSearchCondition("TITLE");
        if(board.getSearchKeyword() == null) board.setSearchKeyword("");
        model.addAttribute("boardList", boardService.getBoardList(board));
        model.addAttribute("search", board);
        return "getBoardList"; // jsp파일이므로 /board를 안붙임
    }
}
