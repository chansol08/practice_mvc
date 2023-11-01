package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class FileGetController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filename = request.getParameter("filename");
        filename = filename.replace("+", " "); //공백이 + 로 나올 경우

        String UPLOAD_DIR = "file_repository";
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File file = new File(uploadPath + "\\" + filename);

        filename = URLEncoder.encode(filename, "UTF-8");

        //다운 규칙
        response.setContentLength((int) file.length());
        response.setContentType("application/x-msdownload; charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + ";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        //실제 다운 부분
        FileInputStream input = new FileInputStream(file);
        OutputStream output = response.getOutputStream();
        byte[] buffer = new byte[1024];

        while (true) {
            int count = input.read(buffer);

            if (count == -1) {
                break;
            }

            output.write(buffer, 0, count);
        }

        input.close();
        output.close();

        return null;
    }
}
