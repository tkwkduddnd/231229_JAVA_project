package day19;

import java.util.*;

public class StdMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StdManager stdManager = new StdManager();
        int choose;

        do {
            System.out.println("-------------------------------");
            System.out.println("1.학생 등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보, 수강정보, 성적)");
            System.out.println("4. 수강신청 | 5. 수강철회 | 6. 성적 추가 | 7. 성적 삭제 | 8. 성적 수정 | 9. 성적 출력 | 10. 종료");
            System.out.println("-------------------------------");

            System.out.print("선택: ");
            choose = scan.nextInt();

            switch(choose) {
                case 1:
                    stdManager.insertStudent(scan);
                    break;
                case 2:
                    stdManager.printStudent();
                    break;
                case 3:
                    stdManager.searchStudent(scan);
                    break;
                case 4:
                    stdManager.registerSubject(scan);
                    break;
                case 5:
                    stdManager.deleteSubject(scan);
                    break;
                case 6:
                    stdManager.addScore(scan);
                    break;
                case 7:
                    stdManager.deleteScore(scan);
                    break;
                case 8:
                    stdManager.modifyScore(scan);
                    break;
                case 9:
                	stdManager.printSA(scan);
                    break;
                case 10:
                	System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        } while (choose != 9);

        scan.close();
    }
}