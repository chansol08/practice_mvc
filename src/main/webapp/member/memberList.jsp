<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-23
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>member list</title>

    <!--  start bootstrap3 info  -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  end bootstrap3 info  -->

    <script type="text/javascript">
        function deleteFn(number) {
            location.href = 'memberDelete.do?number=' + number;
        }
    </script>
</head>
<body>
<table class="table table-bordered">
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이름</td>
        <td>나이</td>
        <td>이메일</td>
        <td>전화번호</td>
        <td></td>
    </tr>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>
                ${member.number}
            </td>
            <td>
                <a href="/memberContent.do?number=${member.number}" />${member.id}
            </td>
            <td>
                ${member.password}
            </td>
            <td>
                ${member.name}
            </td>
            <td>
                ${member.age}
            </td>
            <td>
                ${member.email}
            </td>
            <td>
                ${member.phone}
            </td>
            <td>
                <input type="button" value="삭제" class="btn btn-warning"
                       onclick="deleteFn(${member.number})">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8" align="right">
            <input type="button" value="회원가입" class="btn btn-primary"
                   onclick="location.href='member/memberRegister.html'">
        </td>
    </tr>
</table>
</body>
</html>
