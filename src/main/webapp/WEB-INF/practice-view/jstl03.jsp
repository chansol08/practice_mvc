<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-24
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="count" value="80" />
<html>
<head>
    <title>practice JSTL + EL</title>
</head>
<body>
<c:choose>

    <c:when test="${count % 2 == 0}">
        짝수입니다.
    </c:when>

    <c:when test="${count % 2 != 0}">
        홀수입니다.
    </c:when>

    <c:otherwise>
        일치하는 when 절이 없는 경우에 실행된다.
    </c:otherwise>

</c:choose>
</body>
</html>
