package practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = "chans";
        int age = 30;
        String email = "abc@def.com";

        response.sendRedirect("view/redirect.jsp?data=" + name + "&age=" + age + "&email=" + email);
    }
}
