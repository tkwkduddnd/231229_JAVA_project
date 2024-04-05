package day19;

import java.util.*;

public class StdManager implements StdProgram {
    private List<Student> students = new ArrayList<>();

    public void printStudent() {
        for(Student student : students) {
            System.out.println(student.toString());
            student.printScore();
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
        students.add(new Student(id, name, age, phone, address));
    }

    public void searchStudent(Scanner scan) {
        System.out.println("검색할 학생의 학번을 입력해주세요.");
        String id = scan.next();
        for(Student student : students) {
            if(student.getId().equals(id)) {
                System.out.println(student.toString());
                student.printScore();
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void registerSubject(Scanner scan) {
        System.out.print("수강신청할 학생의 학번과 과목 이름을 입력해주세요: ");
        String id = scan.next();
        String subjectName = scan.next();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addScore(subjectName, 0);  // 성적을 0으로 초기화하면서 과목을 등록
                System.out.println(subjectName + " 과목이 수강신청되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void deleteSubject(Scanner scan) {
        System.out.println("성적을 삭제할 학생의 학번과 과목 정보를 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();

        for(Student student : students) {
            if(student.getId().equals(id)) {
                student.deleteScore(subjectName);
                System.out.println(subjectName + " 과목의 성적이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void correctScore(Scanner scan) {
        System.out.print("성적을 수정할 학생의 학번, 과목 이름, 그리고 새 성적을 입력해주세요: ");
        String id = scan.next();
        String subjectName = scan.next();
        int newGrade = scan.nextInt();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.correctScore(subjectName, newGrade);
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    

    
    public void addScore(Scanner scan) {
        System.out.println("성적을 추가할 학생의 학번, 과목 이름, 그리고 성적을 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        int grade = scan.nextInt();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addScore(subjectName, grade);
                System.out.println(subjectName + " 과목의 성적이 추가되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    
    public void deleteScore(Scanner scan) {
        System.out.println("성적을 삭제할 학생의 학번과 과목 이름을 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.deleteScore(subjectName);
                System.out.println(subjectName + " 과목의 성적이 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    
    public void modifyScore(Scanner scan) {
        System.out.println("성적을 수정할 학생의 학번, 과목 이름, 그리고 새로운 성적을 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        int newGrade = scan.nextInt();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.correctScore(subjectName, newGrade);
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    
    public void printSA(Scanner scan) {
        System.out.println("성적 합계와 평균을 출력할 학생의 학번을 입력해주세요.");
        String id = scan.next();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.printScore();
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }
}

	

