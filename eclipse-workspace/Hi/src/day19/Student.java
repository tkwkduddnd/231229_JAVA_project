package day19;

import java.util.*;
/*
 * 멤버변수 : 이름, 나이, 전화번호, map(과목,점수), 합계, 평균
 * 생성자, 메소드, getter/setter, 출력 메소드
 * 메소드 - 출력 메소드(학생 정보, 과목점수(성적표), 합계, 평균
 * 메소드 - map(과목, 점수) 데이터 추가 메소드
 * 메소드 - map(과목, 점수) 데이터 삭제 메소드 
 */

public class Student {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public void addScore(String subjectName, int grade) {
        grades.put(subjectName, grade);
    }

    public void deleteScore(String subjectName) {
        grades.remove(subjectName);
    }

    public void correctScore(String subjectName, int newGrade) {
        if (grades.containsKey(subjectName)) {
            grades.put(subjectName, newGrade);
            System.out.println(subjectName + " 과목의 성적이 " + newGrade + "로 수정되었습니다.");
        } else {
            System.out.println(subjectName + " 과목의 성적 정보가 없습니다.");
        }
    }

    public void printScore() {
        int total = 0;
        for (Integer grade : grades.values()) {
            total += grade;
        }
        double average = total / (double) grades.size();

        System.out.println(name + " 학생의 성적 합계: " + total);
        System.out.println(name + " 학생의 성적 평균: " + average);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "학번: " + id +", 이름: " + name + ", 나이: " + age +", 전화번호: " + phone +", 주소: " + address;
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}

	
	
		
	

	
	
	


