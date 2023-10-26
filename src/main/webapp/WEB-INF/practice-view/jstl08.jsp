<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="model.MemberVO" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    MemberVO member = new MemberVO();
    member.setNumber(1);
    member.setId("chans");
    member.setName("chans");
    member.setEmail("admin@naver.com");

    List<MemberVO> memberList = new ArrayList<>();
    memberList.add(member);
    memberList.add(member);
    memberList.add(member);
    memberList.add(member);
    memberList.add(member);

    request.setAttribute("memberList", memberList);
%>
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<table border="1">
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>이름</td>
        <td>이메일</td>
    </tr>
    <c:forEach var="member" items="${memberList}">
        <tr>
            <td>${member.number}</td>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
