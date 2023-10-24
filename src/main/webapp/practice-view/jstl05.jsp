<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String[] str = {"사과", "바나나", "포도", "귤", "오랜지"};
    request.setAttribute("str", str);
%>
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<c:forEach var="f" items="${str}">
    ${f}<br>
</c:forEach>
</body>
</html>
