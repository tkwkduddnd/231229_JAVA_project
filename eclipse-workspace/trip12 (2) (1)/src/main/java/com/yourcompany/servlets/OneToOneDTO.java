// 패키지 선언
package com.yourcompany.servlets;

// 필요한 클래스를 임포트
import java.sql.Timestamp;

// OneToOneDTO라는 이름의 클래스 선언
public class OneToOneDTO {
    // 클래스의 멤버 변수 선언
    private int id;  // 글의 고유 번호
    private String title;  // 글의 제목
    private String author;  // 글의 작성자
    private Timestamp date;  // 글이 작성된 시간
    private int viewCount;  // 글의 조회 수

    // 각 멤버 변수에 대한 getter, setter 메서드 선언
    // id의 getter 메서드
    public int getId() {
        return id;
    }

    // id의 setter 메서드
    public void setId(int id) {
        this.id = id;
    }

    // title의 getter 메서드
    public String getTitle() {
        return title;
    }

    // title의 setter 메서드
    public void setTitle(String title) {
        this.title = title;
    }

    // author의 getter 메서드
    public String getAuthor() {
        return author;
    }

    // author의 setter 메서드
    public void setAuthor(String author) {
        this.author = author;
    }

    // date의 getter 메서드
    public Timestamp getDate() {
        return date;
    }

    // date의 setter 메서드
    public void setDate(Timestamp date) {
        this.date = date;
    }

    // viewCount의 getter 메서드
    public int getViewCount() {
        return viewCount;
    }

    // viewCount의 setter 메서드
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
