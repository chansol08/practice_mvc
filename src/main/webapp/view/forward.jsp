<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-23
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="model.MemberVO" %>
<%
    MemberVO member = (MemberVO) request.getAttribute("member");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>controller 에서 받은 데이터 출력</h3> <br><br>
이름 : <%=member.getName()%> <br>
나이 : <%=member.getAge()%> <br>
이메일 : <%=member.getEmail()%>
</body>
</html>
