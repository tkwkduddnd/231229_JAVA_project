package Hospital;

import java.util.Scanner;

import Hospital.PatientInfo;
import Hospital.RecommenDepartment;

public class ViewDepartmentManager {
    public static String viewDepartment(Scanner scan) {
    	RecommenDepartment rd = new RecommenDepartment();
        PatientInfo patient = new PatientInfo();
        String department="";
        int choice = 0;
        do {
            System.out.println("1. 흉부외과");
            System.out.println("2. 정형외과");
            System.out.println("3. 신경과");
            System.out.println("4. 치과");
            System.out.println("5. 비뇨기과");
            System.out.println("6. 이전 메뉴로 돌아가기");
            System.out.println("7. 종료");
            System.out.print("원하는 진료 과를 선택하세요: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1:
                    department = "흉부외과";
                    System.out.println(department + "를 선택하셨습니다.");
                    break;
                case 2:
                    department = "정형외과";
                    System.out.println(department + "를 선택하셨습니다.");
                    break;
                case 3:
                    department = "신경과";
                    System.out.println(department + "를 선택하셨습니다.");
                    break;
                case 4:
                    department = "치과";
                    System.out.println(department + "를 선택하셨습니다.");
                    break;
                case 5:
                    department = "비뇨기과";
                    System.out.println(department + "를 선택하셨습니다.");
                    break;
                case 6:
                    return "";  
                case 7:
                    System.out.println("시스템을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    break;
            }

            if (!department.isEmpty()) {
                System.out.print("진료 목적을 입력하세요: ");
                String purpose = scan.nextLine();
                String recommendedDepartment = rd.recommendDepartment(purpose);
                if (department.equals(recommendedDepartment)) {
                    patient.addDepartment(department, purpose);  
                    System.out.println(department + " 예약이 완료되었습니다.");
                    return department;
                } else if (!recommendedDepartment.isEmpty()) {
                    System.out.println(recommendedDepartment + "를 추천드립니다.");  
                } else {
                    System.out.println("적절한 진료과를 찾지 못했습니다. 다시 입력해주세요.");
                }
            }
        } while(choice != 6 && choice != 7);

        return department;
    }
}
