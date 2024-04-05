package com.yourcompany.servlets; // 패키지 선언

public class User { // User 클래스 선언
    private int id; // 사용자의 id를 저장하는 변수
    private String username; // 사용자의 아이디를 저장하는 변수
    private String password; // 사용자의 비밀번호를 저장하는 변수
    private String fullName; // 사용자의 전체 이름을 저장하는 변수
    private String gender; // 사용자의 성별을 저장하는 변수
    private String birthday; // 사용자의 생일을 저장하는 변수
    private String email; // 사용자의 이메일을 저장하는 변수
    private String phoneNumber; // 사용자의 전화번호를 저장하는 변수
    private String address; // 사용자의 주소를 저장하는 변수
    private String role; // 사용자의 역할을 저장하는 변수

    // 생성자, 게터, 세터 등 필요한 메서드를 추가할 수 있습니다.

    public int getId() { // id의 값을 반환하는 메서드
        return id;
    }

    public void setId(int id) { // id의 값을 설정하는 메서드
        this.id = id;
    }

    public String getUsername() { // username의 값을 반환하는 메서드
        return username;
    }

    public void setUsername(String username) { // username의 값을 설정하는 메서드
        this.username = username;
    }

    public String getPassword() { // password의 값을 반환하는 메서드
        return password;
    }

    public void setPassword(String password) { // password의 값을 설정하는 메서드
        this.password = password;
    }

    public String getFullName() { // fullName의 값을 반환하는 메서드
        return fullName;
    }

    public void setFullName(String fullName) { // fullName의 값을 설정하는 메서드
        this.fullName = fullName;
    }

    public String getGender() { // gender의 값을 반환하는 메서드
        return gender;
    }

    public void setGender(String gender) { // gender의 값을 설정하는 메서드
        this.gender = gender;
    }

    public String getBirthday() { // birthday의 값을 반환하는 메서드
        return birthday;
    }

    public void setBirthday(String birthday) { // birthday의 값을 설정하는 메서드
        this.birthday = birthday;
    }

    public String getEmail() { // email의 값을 반환하는 메서드
        return email;
    }

    public void setEmail(String email) { // email의 값을 설정하는 메서드
        this.email = email;
    }

    public String getPhoneNumber() { // phoneNumber의 값을 반환하는 메서드
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { // phoneNumber의 값을 설정하는 메서드
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() { // address의 값을 반환하는 메서드
        return address;
    }

    public void setAddress(String address) { // address의 값을 설정하는 메서드
        this.address = address;
    }

    public String getRole() { // role의 값을 반환하는 메서드
        return role;
    }

    public void setRole(String role) { // role의 값을 설정하는 메서드
        this.role = role;
    }
}
