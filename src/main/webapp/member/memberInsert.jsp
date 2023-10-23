<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-23
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.MemberVO" %>
<%@ page import="model.MemberDAO" %>
<%
    request.setCharacterEncoding("UTF-8");

    MemberVO member = new MemberVO();
    member.setId(request.getParameter("id"));
    member.setPassword(request.getParameter("password"));
    member.setName(request.getParameter("name"));
    member.setAge(Integer.parseInt(request.getParameter("age")));
    member.setEmail(request.getParameter("email"));
    member.setPhone(request.getParameter("phone"));

    MemberDAO dao = new MemberDAO();
    int count = dao.memberInsert(member);

    if (count > 0) {
        response.sendRedirect("/memberList.do");
    } else {
        throw new ServletException("insert fail");
    }
%>