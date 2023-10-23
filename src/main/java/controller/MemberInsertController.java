package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //요청 바인딩
        MemberVO vo = new MemberVO();
        vo.setId(request.getParameter("id"));
        vo.setPassword(request.getParameter("password"));
        vo.setName(request.getParameter("name"));
        vo.setAge(Integer.parseInt(request.getParameter("age")));
        vo.setEmail(request.getParameter("email"));
        vo.setPhone(request.getParameter("phone"));

        //db 저장
        MemberDAO dao = new MemberDAO();
        int count = dao.memberInsert(vo);

        if (count > 0) {
            response.sendRedirect("/memberList.do");
        } else {
            throw new ServletException("insert fail");
        }
    }
}
