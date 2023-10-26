<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="count" value="7" />
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<c:if test="${count % 2 == 0}">
    짝수입니다.
</c:if>
<c:if test="${count % 2 != 0}">
    홀수입니다.
</c:if>
</body>
</html>
