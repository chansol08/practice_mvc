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
        int count = 0;
        int number = Integer.parseInt(request.getParameter("number"));

        MemberDAO dao = new MemberDAO();
        MemberVO member = dao.memberContent(number);
        member.setAge(Integer.parseInt(request.getParameter("age")));
        member.setEmail(request.getParameter("email"));
        member.setPhone(request.getParameter("phone"));

        if (request.getParameter("mode").equals("fileUpdate")) {
            member.setFilename(request.getParameter("filename"));
            System.out.println("파일 이름 셋팅 완료");
        }

        if (request.getParameter("mode").equals("fileUpdate")) {
            count = dao.memberUpdateFile(member);
            System.out.println("filename db 저장 완료");
        } else {
            count = dao.memberUpdate(member);
            System.out.println("db 저장 완료");
        }

        String nextPage = null;

        if (count > 0) {
            nextPage = "redirect:/memberList.do";
        } else {
            throw new ServletException("update fail");
        }

        return nextPage;
    }
}
