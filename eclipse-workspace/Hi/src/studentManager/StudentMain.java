package studentManager;

import java.util.*;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        int choose;

        do {
            System.out.println("-------------------------------");
            System.out.println("1.학생 등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보, 수강정보)");
            System.out.println("4. 수강신청 | 5. 수강철회 | 6. 종료");
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
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해 주세요.");
            }
        } while (choose != 6);

        scan.close();
    }
}
