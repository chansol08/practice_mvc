package frontcontroller;

public class ViewResolver {

    /**
     * 요청 정보를 받아 경로를 완성
     *
     * @param nextPage 요청 경로
     * @return String 경로
     */
    public static String makeView(String nextPage) {
        return "/WEB-INF/member" + nextPage + ".jsp";
    }
}
