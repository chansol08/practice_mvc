package model;

public class MemberVO {
    private int number;
    private String id;
    private String password;
    private String name;
    private int age;
    private String email;
    private String phone;

    //기본 생성자
    public MemberVO() {

    }

    //저장 시 number 필드는 DB 에서 자동 증가 때문에 number 는 빠진다
    public MemberVO(String id, String password, String name, int age, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    //DB 에서 받아 올 경우의 생성자
    public MemberVO(int number, String id, String password, String name, int age, String email, String phone) {
        this.number = number;
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "number=" + number +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
