package Ex;


import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choose;

        do {
            System.out.println("-------------------------------");
            System.out.println("1.학생 등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보, 수강정보, 성적)");
            System.out.println("4. 수강신청 | 5. 수강철회 | 6. 성적 추가 | 7. 성적 수정 | 8. 성적 삭제 | 9. 종료");
            System.out.println("-------------------------------");

            System.out.print("선택: ");
            choose = scan.nextInt();

            switch(choose) {
                case 1:
                    studentManager.insertStudent(scan);
                    break;
                case 2:
                    studentManager.printStudent();
                    break;
                case 3:
                    studentManager.searchStudent(scan);
                    break;
                case 4:
                    studentManager.registerSubject(scan);
                    break;
                case 5:
                    studentManager.deleteSubject(scan);
                    break;
                case 6:
                    studentManager.addGrade(scan);
                    break;
                case 7:
                    studentManager.correctGrade(scan);
                    break;
                case 8:
                	studentManager.deleteGrade(scan);
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        } while (choose != 9);

        scan.close();
    }
}

