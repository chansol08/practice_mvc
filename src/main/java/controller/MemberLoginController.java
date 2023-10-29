package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLoginController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("user_id");
        String password = request.getParameter("password");

        MemberVO member = new MemberVO();
        member.setId(userId);
        member.setPassword(password);

        MemberDAO dao = new MemberDAO();
        String userName = dao.memberLogin(member);

        if (userName != null && !(userName.equals(""))) {
            request.getSession().setAttribute("userId", userId);
            request.getSession().setAttribute("userName ", userName);
        } else {
            request.getSession().setAttribute("userId", "");
            request.getSession().setAttribute("userName ", "");
            request.getSession().setAttribute("message", "사용자 정보가 올바르지 않습니다.");
        }

        return "redirect:/memberList.do";
    }
}
