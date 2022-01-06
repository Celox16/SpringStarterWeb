<%@page contentType="text/html; charset=EUC-KR" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--
    EL(Expression Language)�̶�?
    session�̳� request ���� ��ü�� ��ϵ� �����͸� JSP ���Ͽ��� �����ϱ� ���� ǥ����

    JSTL(JSP Standard Tag Library)�̶�?
    JSP ���Ͽ��� if, for, switch ��� ���� �ڹ� �ڵ带 ��ü�ϱ� ���� �����Ǵ� ǥ�� �׼� �±�
    �ٸ� �ݵ�� taglib ������ �ʿ��ϴ�. (XML, Namespace ��ϰ� ������ ����)
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta content="text/html; charset=EUC-KR" http-equiv="Content-Type">
    <title>�� ��</title>
</head>
<body>
<center>
    <h1>�Խñ� ��</h1>
    <hr>
    <form action="/board/updateBoard" method="post">
        <input name="seq" type="hidden" value="${board.seq}"/>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td bgcolor="orange" width="70">����</td>
                <td align="left"><input name="title" type="text" value="${board.title}"/></td>
            </tr>
            <tr>
                <td bgcolor="orange">�ۼ���</td>
                <td align="left">${board.writer}</td>
            </tr>
            <tr>
                <td bgcolor="orange">����</td>
                <td align="left"><textarea rows="10" cols="40" name="content">${board.content}</textarea></td>
            </tr>
            <tr>
                <td bgcolor="orange">�����</td>
                <td align="left">${board.regdate}</td>
            </tr>
            <tr>
                <td bgcolor="orange">��ȸ��</td>
                <td align="left">${board.cnt}</td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="�� ����"/></td>
            </tr>
        </table>
    </form>

    <hr>
    <a href="/board/insertBoardView">�� ���</a>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <!-- �׳� ADMIN�� �ƴ϶� ROLE_ADMIN ���� -->
        <a href="/board/deleteBoard?seq=${board.seq}">�� ����</a>
    </sec:authorize>

    <a href="/board/getBoardList">�� ���</a>
</center>
</body>
</html>