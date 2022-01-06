package com.fastcampus.persistence;

import com.fastcampus.domain.Board;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 메모리에 띄우려
public class BoardDAOMyBatis {
    @Autowired // MyBatis 컨테이너를 얻는다.
    // mybatis 스타터를 추가했으므로 자동으로 다운로드 되어있다. sqlsessiontemplate같은
    // xml에 등록했던 정보들이 자동으로 다운로드 되어있는 셈
    private SqlSessionTemplate mybatis;

    public void inserBoard(Board board) {
        mybatis.insert("insertBoard", board); // ""안ㅇ니 interface 메서드 이름과 반드시 일치해야한다.
    }

    public List<Board> getBoardList() {
        return mybatis.selectList("getBoardList");
    }

    // mvc에서 mybatis를 사용하려면 board-mapping.xml, business-layer.xml, sql-map-config.xml 있었어야했다.
    // board-mapping.xml이 board mapper 인터페이스로 바뀌고 나머지 두개는 날아갔다.
}
