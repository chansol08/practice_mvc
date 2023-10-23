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
import java.util.List;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> members = dao.memberList();

        request.setAttribute("members", members);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberList.jsp");
        dispatcher.forward(request, response);
    }
}
