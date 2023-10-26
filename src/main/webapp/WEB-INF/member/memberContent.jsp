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
    <title>member content</title>

    <!--  start bootstrap3 info  -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  end bootstrap3 info  -->
</head>
<body>
<form action="/memberUpdate.do" method="post">
    <input type="hidden" name="number" value="${member.number}" />
    <table class="table table-bordered">
        <c:if test="${member != null}">
            <tr>
                <td colspan="2">${member.name} 회원의 상세 보기</td>
            </tr>
            <tr>
                <td>번호</td>
                <td>${member.number}</td>
            </tr>
            <tr>
                <td>아이디</td>
                <td>${member.id}</td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td>${member.password}</td>
            </tr>
            <tr>
                <td>이름</td>
                <td>${member.name}</td>
            </tr>
            <tr>
                <td>나이</td>
                <td><input type="text" name="age" value="${member.age}"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" value="${member.email}"></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="phone" value="${member.phone}"></td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="수정하기" class="btn btn-primary">
                <input type="reset" value="취소" class="btn btn-warning">
                <input type="button" value="리스트" onclick="location.href='/memberList.do'" class="btn">
            </td>
        </tr>
    </table>
</form>
</body>
</html>