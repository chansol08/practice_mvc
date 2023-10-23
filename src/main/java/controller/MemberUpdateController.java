package controller;


import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        MemberVO member = new MemberVO();
        member.setNumber(Integer.parseInt(request.getParameter("number")));
        member.setAge(Integer.parseInt(request.getParameter("age")));
        member.setEmail(request.getParameter("email"));
        member.setPhone(request.getParameter("phone"));

        MemberDAO dao = new MemberDAO();
        int count = dao.memberUpdate(member);

        if (count > 0) {
            response.sendRedirect("/memberList.do");
        } else {
            throw new ServletException("update fail");
        }
    }
}
