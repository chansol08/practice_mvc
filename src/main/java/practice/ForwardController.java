package practice;

import model.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = "chans";
        int age = 30;
        String email = "abc@def.com";

        MemberVO member = new MemberVO();
        member.setName(name);
        member.setAge(age);
        member.setEmail(email);

        request.setAttribute("member", member);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/forward.jsp");
        dispatcher.forward(request, response);
    }
}
