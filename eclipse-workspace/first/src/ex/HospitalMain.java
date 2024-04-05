package ex;

import java.util.Scanner;

public class HospitalMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HospitalManager manager = new HospitalManager();

        int choice = 0;
        do {
            if(manager.loggedInId != null) { 
                System.out.println("1. 예약 생성");
                System.out.println("2. 예약 조회");
                System.out.println("3. 예약 수정");
                System.out.println("4. 예약 취소");
                System.out.println("5. 의사 정보 조회");
                System.out.println("6. 진료 시간표 조회");
                System.out.println("7. 예약 알림");
                System.out.println("8. 예약 내역 관리");
                System.out.println("9. 로그아웃");
                System.out.println("10. 종료");
            } else {
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 종료");
            }
            
            System.out.print("원하는 기능을 선택하세요: ");
            choice = scan.nextInt();

            if(manager.loggedInId != null) {
                switch(choice) {
                    case 1:
                        manager.medicalReservation(scan);
                        break;
                    case 2:
                        manager.viewReservation(scan);
                        break;
                    case 3:
                        manager.modifyReservation(scan);
                        break;
                    case 4:
                        manager.cancelReservation(scan);
                        break;
                    case 5:
                        manager.viewDoctorInfo(scan);
                        break;
                    case 6:
                        manager.viewSchedule(scan);
                        break;
                    case 7:
                        manager.sendNotification(scan);
                        break;
                    case 8:
                        manager.manageReservations(scan);
                        break;
                    case 9:
                        manager.loggedInId = null; 
                        System.out.println("로그아웃 되었습니다.");
                        break;
                    case 10:
                        System.out.println("시스템을 종료합니다.");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                        break;
                }
            } else {
                switch(choice) {
                    case 1:
                        manager.signUp(scan);
                        break;
                    case 2:
                        manager.signIn(scan);
                        break;
                    case 3:
                        System.out.println("시스템을 종료합니다.");
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                        break;
                }
            }
        } while(choice != 3 || (manager.loggedInId != null && choice != 10));
        
        scan.close();
    }
}