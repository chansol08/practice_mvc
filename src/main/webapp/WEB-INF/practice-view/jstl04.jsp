<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1" >
    <font size="${i}">야호</font><br>
</c:forEach>
</body>
</html>
