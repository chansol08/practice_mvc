package frontcontroller;

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

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("euc-kr");

        String url = request.getRequestURI();
        System.out.println("url = " + url);
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String command = url.substring(contextPath.length());
        System.out.println("command = " + command);

        MemberDAO dao = new MemberDAO();

        if (command.equals("/memberList.do")) {
            List<MemberVO> members = dao.memberList();

            request.setAttribute("members", members);
            RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberList.jsp");
            dispatcher.forward(request, response);
        } else if (command.equals("/memberInsert.do")) {
            MemberVO member = new MemberVO();
            member.setId(request.getParameter("id"));
            member.setPassword(request.getParameter("password"));
            member.setName(request.getParameter("name"));
            member.setAge(Integer.parseInt(request.getParameter("age")));
            member.setEmail(request.getParameter("email"));
            member.setPhone(request.getParameter("phone"));

            int count = dao.memberInsert(member);

            if (count > 0) {
                response.sendRedirect("/memberList.do");
            } else {
                throw new ServletException("insert fail");
            }
        } else if (command.equals("/memberRegister.do")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberRegister.html");
            dispatcher.forward(request, response);
        } else if (command.equals("/memberContent.do")) {
            int number = Integer.parseInt(request.getParameter("number"));
            MemberVO member = dao.memberContent(number);

            request.setAttribute("member", member);
            RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberContent.jsp");
            dispatcher.forward(request, response);
        } else if (command.equals("/memberUpdate.do")) {
            int number = Integer.parseInt(request.getParameter("number"));
            MemberVO member = dao.memberContent(number);
            member.setAge(Integer.parseInt(request.getParameter("age")));
            member.setEmail(request.getParameter("email"));
            member.setPhone(request.getParameter("phone"));

            int count = dao.memberUpdate(member);

            if (count > 0) {
                response.sendRedirect("/memberList.do");
            } else {
                throw new ServletException("update fail");
            }
        } else if (command.equals("/memberDelete.do")) {
            int number = Integer.parseInt(request.getParameter("number"));

            int count = dao.memberDelete(number);

            if (count > 0) {
                response.sendRedirect("/memberList.do");
            } else {
                throw new ServletException("delete fail");
            }
        }
    }
}
