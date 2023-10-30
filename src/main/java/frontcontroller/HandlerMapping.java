package frontcontroller;

import controller.*;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private Map<String, Controller> mapping;

    /**
     * 클라이언트 의 요청 정보를 Map 으로 저장(초기화)
     */
    public HandlerMapping() {
        mapping = new HashMap<>();
        mapping.put("/memberList.do", new MemberListController());
        mapping.put("/memberInsert.do", new MemberInsertController());
        mapping.put("/memberRegister.do", new MemberRegisterController());
        mapping.put("/memberContent.do", new MemberContentController());
        mapping.put("/memberUpdate.do", new MemberUpdateController());
        mapping.put("/memberDelete.do", new MemberDeleteController());
        mapping.put("/memberLogin.do", new MemberLoginController());
        mapping.put("/memberLogout.do", new MemberLogoutController());
    }

    /**
     * 요청 정보를 꺼내 반환
     *
     * @param key 요청 URL
     * @return 요청 URL 에 맞는 POJO Controller
     */
    public Controller getController(String key) {
        return mapping.get(key);
    }
}
