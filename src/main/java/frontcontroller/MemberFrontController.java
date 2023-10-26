package frontcontroller;

import controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String url = request.getRequestURI();
        System.out.println("url = " + url);
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String command = url.substring(contextPath.length());
        System.out.println("command = " + command);

        HandlerMapping mapping = new HandlerMapping();
        Controller controller = mapping.getController(command);
        String nextPage = controller.requestHandler(request, response);

        if (nextPage != null) {
            if (nextPage.indexOf("redirect:") != -1) {
                response.sendRedirect(nextPage.split(":")[1]);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
                dispatcher.forward(request, response);
            }
        }
    }
}
