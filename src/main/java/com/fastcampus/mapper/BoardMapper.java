package com.fastcampus.mapper;

import com.fastcampus.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // board-mapping.xml 같은 SQL이 저장되는 XML을 대체한다.
public interface BoardMapper {
    public void inserBoard(Board board);

    public List<Board> getBoardList();
}
