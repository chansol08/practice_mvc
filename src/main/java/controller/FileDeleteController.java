package controller;

import model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

public class FileDeleteController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));
        String filename = request.getParameter("filename");
        filename = URLEncoder.encode(filename, "UTF-8");
        filename = filename.replace("+", " ");

        String UPLOAD_DIR = "file_repository";
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File file = new File(uploadPath + "\\" + filename);

        if (file.exists()) {
            file.delete();
            System.out.println("파일 삭제 완료");
        }

        MemberDAO dao = new MemberDAO();
        int count = dao.memberDeleteFile(number);

        String nextPage = null;

        if (count > 0) {
            nextPage = "redirect:/memberContent.do?number=" + number;
        } else {
            throw new ServletException("update fail");
        }

        return nextPage;
    }
}
