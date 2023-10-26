<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<String> list = new ArrayList<>();
    list.add("python");
    list.add("Java");
    list.add("Node.js");
    list.add("C++");
    list.add("JQuery");
    request.setAttribute("list", list);
%>
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<c:forEach var="list" items="${list}">
    ${list}<br>
</c:forEach>
</body>
</html>
