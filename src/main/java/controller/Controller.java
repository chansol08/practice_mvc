package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {

    /**
     * 모든 POJO 의 공통 메서드
     *
     * @param request 요청에 관련된 parameter
     * @param response 응답에 관련된 parameter
     * @return String (경로)
     * @throws ServletException 서블릿 예외
     * @throws IOException 입/출력 관련 예외
     */
    String requestHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
