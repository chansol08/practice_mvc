package controller;

import model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberDoubleCheckController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        MemberDAO dao = new MemberDAO();
        boolean isDuplication = dao.memberDoubleCheck(id);

        response.getWriter().print(isDuplication);

        return null;
    }
}
