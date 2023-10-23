<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-23
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
%>
<html>
<head>
    <title>test page</title>
</head>
<body>
controller 에서 받은 값을 출력 : <%=name%>, <%=age%>, <%=email%>
</body>
</html>
