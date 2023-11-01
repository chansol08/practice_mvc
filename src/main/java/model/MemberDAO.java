package model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MemberDAO {
    private static SqlSessionFactory sqlSessionFactory;

    //초기화 블럭 - 프로그램 실행 시 딱 한 번만 실행되는 코드 영역
    static {
        try {
            String resource = "config/mybatis/config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 저장된 회원의 목록을 조회
     *
     * @return 회원 리스트
     */
    public List<MemberVO> memberList() {
        SqlSession session = sqlSessionFactory.openSession();
        List<MemberVO> members = session.selectList("memberList");
        session.close();

        return members;
    }

    /**
     * memberVO 필드에 filename 이 없는 경우 저장
     *
     * @param member memberVO
     * @return int 저장된 행의 숫자
     */
    public int memberInsert(MemberVO member) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("memberInsert", member);
        session.commit();
        session.close();

        return count;
    }

    /**
     * memberVO 필드에 filename 이 있는 경우 저장
     *
     * @param member MemberVO
     * @return int 저장된 행의 숫자
     */
    public int memberInsertFile(MemberVO member) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("memberInsertFile", member);
        session.commit();
        session.close();

        return count;
    }

    /**
     * 저장된 회원을 삭제
     *
     * @param number 회원의 기본키
     * @return 삭제된 행의 숫자
     */
    public int memberDelete(int number) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("memberDelete", number);
        session.commit();
        session.close();

        return count;
    }

    /**
     * 저장된 한 명의 회원 정보를 조회
     *
     * @param number 회원의 기본키
     * @return MemberVO 회원 객체
     */
    public MemberVO memberContent(int number) {
        SqlSession session = sqlSessionFactory.openSession();
        MemberVO member = session.selectOne("memberContent", number);
        session.close();

        return member;
    }

    /**
     * 회원의 정보를 수정
     *
     * @param member 회원 객체
     * @return 업데이트된 행의 숫자
     */
    public int memberUpdate(MemberVO member) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("memberUpdate", member);
        session.commit();
        session.close();

        return count;
    }

    /**
     * 회원 로그인
     *
     * @param member 회원의 아이디와 비밀번호를 담은 member객체
     * @return userName 회원의 이름을 반환
     */
    public String memberLogin(MemberVO member) {
        SqlSession session = sqlSessionFactory.openSession();
        String userName = session.selectOne("memberLogin", member);
        session.close();

        return userName;
    }

    /**
     * 아이디 중복 확인
     *
     * @param id 회원 가입할 아이디
     * @return true || false
     */
    public boolean memberDoubleCheck(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        String checkId = session.selectOne("memberDoubleCheck", id);

        if (checkId != null) {
            return true;
        } else {
            return false;
        }
    }
}
