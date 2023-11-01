package controller;

import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberInsertController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int count = 0;
        MemberDAO dao = new MemberDAO();
        MemberVO member = new MemberVO();
        member.setId(request.getParameter("id"));
        member.setPassword(request.getParameter("password"));
        member.setName(request.getParameter("name"));
        member.setAge(Integer.parseInt(request.getParameter("age")));
        member.setEmail(request.getParameter("email"));
        member.setPhone(request.getParameter("phone"));

        if (request.getParameter("mode").equals("fileAdd")) {
            member.setFilename(request.getParameter("filename"));

            count = dao.memberInsertFile(member);
        } else {
            count = dao.memberInsert(member);
        }

        String nextPage = null;

        if (count > 0) {
            nextPage = "redirect:/memberList.do";
        } else {
            throw new ServletException("insert fail");
        }

        return nextPage;
    }
}
