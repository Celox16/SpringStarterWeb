<%@page contentType="text/html; charset=EUC-KR" %>

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
    <title>새글등록</title>
</head>
<body>
<center>
    <h1>새글 등록하기</h1>
    <h3><font color="red">${user.name}</font>님 로그인 환영합니다...<a href="/member/logout">LOG-OUT</a></h3>
    <hr>
    <form action="/board/insertBoard" method="post">
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">제목</td>
                <td align="left"><input type="text" name="title"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">내용</td>
                <td align="left"><textarea rows="10" cols="40" name="content"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="새글 등록"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>