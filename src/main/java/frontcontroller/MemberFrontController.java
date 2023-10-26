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

        Controller controller = null;
        String nextPage = null;

        if (command.equals("/memberList.do")) {
            controller = new MemberListController();
            nextPage = controller.requestHandler(request, response);
        } else if (command.equals("/memberInsert.do")) {
            controller = new MemberInsertController();
            nextPage = controller.requestHandler(request, response);
        } else if (command.equals("/memberRegister.do")) {
            controller = new MemberRegisterController();
            nextPage = controller.requestHandler(request, response);
        } else if (command.equals("/memberContent.do")) {
            controller = new MemberContentController();
            nextPage = controller.requestHandler(request, response);
        } else if (command.equals("/memberUpdate.do")) {
            controller = new MemberUpdateController();
            nextPage = controller.requestHandler(request, response);
        } else if (command.equals("/memberDelete.do")) {
            controller = new MemberDeleteController();
            nextPage = controller.requestHandler(request, response);
        }

        if (nextPage != null) {
            if (nextPage.indexOf("redirect:") != -1) {
                response.sendRedirect(nextPage.split(":")[1]);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
                dispatcher.forward(request, response);
            }
        }
    }
}
