<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--
    EL(Expression Language)이란?
    session이나 request 내장 객체에 등록된 데이터를 JSP 파일에서 접근하기 위한 표현식

    JSTL(JSP Standard Tag Library)이란?
    JSP 파일에서 if, for, switch 등과 같은 자바 코드를 대체하기 위해 제공되는 표준 액션 태그
    다만 반드시 taglib 설정이 필요하다. (XML, Namespace 등록과 동일한 개념)
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>글 목록</title>
</head>
<body>
<center>
    <h1><spring:message code="message.board.list.main_title"/></h1>

    <!-- 스프링 시큐리티는 인증에 성공한 사용자 객체를 세션에 principal 이름으로 자동 등록해준다. -->
    <sec:authentication property="principal" var="user"/>

    <h3><font color="red">${user.username}</font>님 로그인 환영합니다...<a href="/member.logout">LOG-OUT</a></h3>

    <!-- 검색 시작 -->
    <form action="/board/getBoardList" method="post">
        <table border="1" cellpadding="0" cellspacing="0" width="700">
            <tr>
                <td align="right">
                    <select name="searchCondition">
                        <option value="TITLE" <c:if test="${searchCondition == 'TITLE'}">selected</c:if>제목></option>
                        <option value="CONTENT" <c:if test="${searchCondition == 'CONTENT'}">selected</c:if>내용></option>
                    </select>
                    <input name="searchKeyword" type="text" value="${search.searchKeyword}"/>
                    <input type="submit" value="검색"/>
                </td>
            </tr>
        </table>
    </form>
    <!-- 검색 종료 -->

    <table border="1" cellpadding="0" cellspacing="0" width="700">
        <tr>
            <th bgcolor="orange" width="100">번호</th>
            <th bgcolor="orange" width="200">제목</th>
            <th bgcolor="orange" width="150">작성자</th>
            <th bgcolor="orange" width="150">등록일</th>
            <th bgcolor="orange" width="100">조회수</th>
        </tr>

        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.seq}</td>
                <td align="left"><a href="/board/getBoard?seq=${board.seq}">${board.title}</a> </td>
                <td>${board.writer}</td>
                <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
                <td>${board.cnt}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="/board.inserBoardView">새글 등록</a>
</center>
</body>
</html>