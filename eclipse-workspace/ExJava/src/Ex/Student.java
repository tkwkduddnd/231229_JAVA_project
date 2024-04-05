package Ex;

import java.util.*;

public class Student {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String address;
    private List<String> subjects = new ArrayList<>();
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String id, String name, int age, String phone, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public void addSubject(String subjectName) {
        subjects.add(subjectName);
    }

    public void deleteSubject(String subjectName) {
        subjects.remove(subjectName);
        grades.remove(subjectName);
    }

    public void printSubjects() {
        System.out.println(name + " 학생이 수강하는 과목");
        for(String subjectName : subjects) {
            System.out.println(subjectName);
        }
    }

    public void addGrade(String subjectName, int grade) {
        if (subjects.contains(subjectName)) {
            grades.put(subjectName, grade);
        } else {
            System.out.println(subjectName + " 과목이 수강 과목에 없습니다.");
        }
    }

    public void deleteGrade(String subjectName) {
        grades.remove(subjectName);
    }

    public void printGrades() {
        System.out.println(name + " 학생의 성적");
        for(String subjectName : subjects) {
            Integer grade = grades.get(subjectName);
            if (grade != null) {
                System.out.println(subjectName + " 과목의 성적: " + grade);
            } else {
                System.out.println(subjectName + " 과목의 성적이 아직 입력되지 않았습니다.");
            }
        }
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

    public List<String> getSubjects() {
        return subjects;
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
}
