package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileAddController implements Controller {

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //업로드 경로 선택
        String UPLOAD_DIR = "file_repository";
        String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File currentDirPath = new File(uploadPath);

        //경로가 없다면 만듬
        if (!currentDirPath.exists()) {
            currentDirPath.mkdir();
        }

        /*
        파일 업로드 시 필요한 api
        임시 저장 경로 설정
         */
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(currentDirPath);
        factory.setSizeThreshold(1024 * 1024);

        String fileName = null;
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem = items.get(i);

                if (fileItem.isFormField()) {
                    System.out.println(fileItem.getFieldName() + " = " + fileItem.getString("UTF-8"));
                } else {
                    if (fileItem.getSize() > 0) {
                        int index = fileItem.getName().lastIndexOf("\\");

                        if (index == -1) {
                            index = fileItem.getName().lastIndexOf("/");
                        }

                        fileName = fileItem.getName().substring(index + 1);
                        File uploadFile = new File(currentDirPath + "\\" + fileName);

                        if (uploadFile.exists()) {
                            fileName = System.currentTimeMillis() + "_" + fileName;
                            uploadFile = new File(currentDirPath + "\\" + fileName);
                        }

                        fileItem.write(uploadFile);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(fileName);

        return null;
    }
}
