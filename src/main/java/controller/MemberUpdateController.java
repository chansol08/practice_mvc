package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberUpdateController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));

        MemberDAO dao = new MemberDAO();
        MemberVO member = dao.memberContent(number);
        member.setAge(Integer.parseInt(request.getParameter("age")));
        member.setEmail(request.getParameter("email"));
        member.setPhone(request.getParameter("phone"));

        int count = dao.memberUpdate(member);
        String nextPage = null;

        if (count > 0) {
            nextPage = "redirect:/memberList.do";
        } else {
            throw new ServletException("update fail");
        }

        return nextPage;
    }
}
