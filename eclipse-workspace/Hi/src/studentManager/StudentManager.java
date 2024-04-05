package studentManager;

import java.util.Scanner;

public class StudentManager {
    private Student[] students = new Student[10];
    private int count = 0;

    public void printStudent() {
        for(int i=0; i<count; i++) {
            System.out.println(students[i].toString());
        }
    }

    public void insertStudent(Scanner scan) {
        System.out.println("학생 정보를 입력해주세요.");
        System.out.print("학번: ");
        String id = scan.next();
        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("나이: ");
        int age = scan.nextInt();
        System.out.print("전화번호: ");
        String phone = scan.next();
        System.out.print("주소: ");
        String address = scan.next();
        students[count] = new Student(id, name, age, phone, address);
        count++;
        if(count== students.length) {
            Student[] temp = new Student[students.length];
            for(int i = 0; i < students.length; i++) {
                temp[i] = students[i];
            }
            students = temp;
        }
    }

    public void searchStudent(Scanner scan) {
        System.out.println("검색할 학생의 학번을 입력해주세요.");
        String id = scan.next();
        for(int i=0; i<count; i++) {
            if(students[i].getId().equals(id)) {
                System.out.println(students[i].toString());
                students[i].printSubjects();
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void registerSubject(Scanner scan) {
        System.out.println("수강 신청할 학생의 학번과 수강 신청할 과목 정보를 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        Subject subject = new Subject(subjectName);
        for(int i=0; i<count; i++) {
            if(students[i].getId().equals(id)) {
                students[i].addSubject(subject);
                System.out.println(subjectName + "과목이 수강 신청되엇ㅅㅂ니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void deleteSubject(Scanner scan) {
        System.out.println("수강 철회할 학생의 학번과 수강 철회할 과목 정보를 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        
        for(int i=0; i<count; i++) {
            if(students[i].getId().equals(id)) {
            	
                for(Subject subject : students[i].getSubjects()) {
                    if(subject.getSubjectName().equals(subjectName)) {
                        students[i].deleteSubject(subject);
                        System.out.println(subjectName + "과목이 수강 철회되었습니다.");
                        return;
                    }
                }
                System.out.println("해당 과목을 찾을 수 없습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }
}
