package Ex;

import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void printStudent() {
        for(Student student : students) {
            System.out.println(student.toString());
            student.printSubjects();
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
                student.printSubjects();
                student.printGrades();
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void registerSubject(Scanner scan) {
        System.out.print("수강 신청할 학생의 학번과 과목 이름을 입력해주세요: ");
        String id = scan.next();
        String subjectName = scan.next();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addSubject(subjectName);
                System.out.println(subjectName + " 과목이 수강 신청되었습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void deleteSubject(Scanner scan) {
        System.out.println("수강 철회할 학생의 학번과 수강 철회할 과목 정보를 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();
        
        for(Student student : students) {
            if(student.getId().equals(id)) {
                if(student.getSubjects().contains(subjectName)) {
                    student.deleteSubject(subjectName);
                    System.out.println(subjectName + "과목이 수강 철회되었습니다.");
                    return;
                }
                System.out.println("해당 과목을 찾을 수 없습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }
    
    public void addGrade(Scanner scan) {
        System.out.print("성적을 추가할 학생의 학번, 과목 이름, 그리고 성적을 입력해주세요: ");
        String id = scan.next();
        String subjectName = scan.next();
        int grade = scan.nextInt();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.addGrade(subjectName, grade);
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

    public void deleteGrade(Scanner scan) {
        System.out.println("성적을 삭제할 학생의 학번과 과목 정보를 입력해주세요.");
        String id = scan.next();
        String subjectName = scan.next();

        for(Student student : students) {
            if(student.getId().equals(id)) {
                if(student.getSubjects().contains(subjectName)) {
                    student.deleteGrade(subjectName);
                    System.out.println(subjectName + " 과목의 성적이 삭제되었습니다.");
                    return;
                }
                System.out.println("해당 과목을 찾을 수 없습니다.");
                return;
            }
        }
        System.out.println("해당 학번의 학생을 찾을 수 없습니다.");
    }

	public void correctGrade(Scanner scan) {
		
	}
}