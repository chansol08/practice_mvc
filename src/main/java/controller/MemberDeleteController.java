package controller;

import model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));

        MemberDAO dao = new MemberDAO();
        int count = dao.memberDelete(number);

        if (count > 0) {
            response.sendRedirect("/memberList.do");
        } else {
            throw new ServletException("delete fail");
        }
    }
}
