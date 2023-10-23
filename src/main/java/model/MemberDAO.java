package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * MySQL db connection method
     * mysql db 에 연결
     */
    public void getConnect() {
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
        String user = "root";
        String password = "admin12345";

        //MySQL Driver Loading
        try {
            //동적 로딩
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * member insert method
     * 입력받은 회원의 정보를 db에 저장
     */
    public int memberInsert(MemberVO vo) {
        String sql = "insert into member(id, password, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";

        getConnect();

        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPassword());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());
            //실행
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return count;
    }

    /**
     * member select method
     * 회원 리스트 반환
     *
     * @return member list
     */
    public List<MemberVO> memberList() {
        String sql = "select * from member";

        getConnect();

        List<MemberVO> members = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MemberVO member = new MemberVO();
                member.setNumber(rs.getInt("number"));
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAge(rs.getInt("age"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));

                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return members;
    }

    /**
     * member Update method
     * PK를 받아 나이, 이메일, 전화번호를 수정
     *
     * @param member
     * @return int count
     */
    public int memberUpdate(MemberVO member) {
        String sql = "update member set age=?, email=?, phone=? where number=?";

        getConnect();

        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, member.getAge());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.setInt(4, member.getNumber());
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return count;
    }

    /**
     * member delete method
     * 삭제된 행의 숫자를 반환
     *
     * @param number
     * @return int count
     */
    public int memberDelete(int number) {
        String sql = "delete from member where number=?";

        getConnect();

        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, number);
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return count;
    }

    /**
     * member content method
     * 특정 회원의 정보를 반환
     *
     * @param number
     * @return member
     */
    public MemberVO memberContent(int number) {
        String sql = "select * from member where number=?";

        getConnect();

        MemberVO member = new MemberVO();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, number);
            rs = ps.executeQuery();

            if (rs.next()) {
                member.setNumber(rs.getInt("number"));
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAge(rs.getInt("age"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return member;
    }

    /**
     * disconnect method
     * 리소스 반환
     */
    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
