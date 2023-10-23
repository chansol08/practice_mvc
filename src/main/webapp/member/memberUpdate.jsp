<%--
  Created by IntelliJ IDEA.
  User: chans
  Date: 2023-10-23
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="model.MemberDAO" %>
<%@ page import="model.MemberVO" %>
<%
    request.setCharacterEncoding("UTF-8");
    int number = Integer.parseInt(request.getParameter("number"));
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");

    MemberVO member = new MemberVO();
    member.setNumber(number);
    member.setAge(age);
    member.setEmail(email);
    member.setPhone(phone);

    MemberDAO dao = new MemberDAO();
    int count = dao.memberUpdate(member);

    if (count > 0) {
        response.sendRedirect("/member/memberList.jsp");
    } else {
        throw new ServletException("update fail");
    }

%>
