package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));

        MemberDAO dao = new MemberDAO();
        MemberVO member = dao.memberContent(number);

        request.setAttribute("member", member);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberContent.jsp");
        dispatcher.forward(request, response);
    }
}
