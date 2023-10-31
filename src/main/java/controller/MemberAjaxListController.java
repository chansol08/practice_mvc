package controller;

import com.google.gson.Gson;
import model.MemberDAO;
import model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberAjaxListController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> members = dao.memberList();

        Gson gson = new Gson();
        String json = gson.toJson(members);
        System.out.println("json = " + json);

        response.setContentType("text/json; charset=UTF-8");
        response.getWriter().print(json);

        return null;
    }
}
