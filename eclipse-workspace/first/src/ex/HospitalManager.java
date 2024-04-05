package ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HospitalManager {
    Scanner scan = new Scanner(System.in);
    String loggedInId = null;

    Map<String, String> users = new HashMap<>();
    Map<String, List<String>> userReservations = new HashMap<>();

    public void medicalReservation(Scanner scan) {
    	System.out.println("이름을 입력하세요: ");
        String name = scan.nextLine();

        System.out.println("나이를 입력하세요: ");
        int age = scan.nextInt();
        scan.nextLine();  // 숫자 입력 후의 줄바꿈 문자를 소비

        System.out.println("성별을 입력하세요.(남자/여자)");
        String gender = scan.nextLine();

        System.out.println("전화번호를 입력하세요: ");
        String phone = scan.nextLine();

        String reservation = "이름: "+name+", 나이: "+age+", 성별: "+gender+", 전화번호: "+phone;

        ViewDepartmentManager viewDepartmentManager = new ViewDepartmentManager();
        String department = viewDepartmentManager.viewDepartment(scan);
        
        // 예약 정보를 맵에 저장
        List<String> reservations;
        if (userReservations.containsKey(loggedInId)) {
            reservations = userReservations.get(loggedInId);
        } else {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        userReservations.put(loggedInId, reservations);

        if (department.isEmpty()) {
            System.out.println("예약이 취소되었습니다.");
        } else {
            System.out.println(department + " 예약이 완료되었습니다.");
        }
    }

    public void viewReservation(Scanner scan) {
        List<String> reservations = userReservations.get(loggedInId);
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("예약 내역이 없습니다.");
        } else {
            System.out.println("예약 내역:");
            for (String reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    public void modifyReservation(Scanner scan) {
        List<String> reservations = userReservations.get(loggedInId);
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("예약 내역이 없습니다.");
        } else {
            System.out.println("예약 내역:");
            for (String reservation : reservations) {
                System.out.println(reservation);
            }
        }

        System.out.print("수정할 예약 번호를 입력하세요: ");
        int index = scan.nextInt() - 1;
        scan.nextLine();
        if (index < 0 || index >= reservations.size()) {
            System.out.println("잘못된 예약 번호입니다.");
        } else {
            System.out.print("새로운 예약 내용을 입력하세요: ");
            String newReservation = scan.nextLine();
            reservations.set(index, newReservation);
            System.out.println("예약이 수정되었습니다.");
        }
    }

    public void cancelReservation(Scanner scan) {
        List<String> reservations = userReservations.get(loggedInId);
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("예약 내역이 없습니다.");
        } else {
            System.out.println("예약 내역:");
            for (String reservation : reservations) {
                System.out.println(reservation);
            }
        }
        
        System.out.print("취소할 예약 번호를 입력하세요: ");
        int index = scan.nextInt() - 1;
        scan.nextLine();
        if (index < 0 || index >= reservations.size()) {
            System.out.println("잘못된 예약 번호입니다.");
        } else {
            reservations.remove(index);
            System.out.println("예약이 취소되었습니다.");
        }
    }

    public void viewDoctorInfo(Scanner scan) {
        // TODO Auto-generated method stub
    }

    public void viewSchedule(Scanner scan) {
        // TODO Auto-generated method stub
    }

    public void sendNotification(Scanner scan) {
        List<String> reservations = userReservations.get(loggedInId);
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("예약 내역이 없어 알림을 보낼 수 없습니다.");
        } else {
            System.out.println("예약 알림을 모든 사용자에게 발송하였습니다.");
        }
    }

    public void manageReservations(Scanner scan) {
        System.out.println("예약 내역을 관리합니다. 다음 중 하나를 선택하세요:");
        System.out.println("1. 예약 조회\n2. 예약 수정\n3. 예약 취소");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                viewReservation(scan);
                break;
            case 2:
                modifyReservation(scan);
                break;
            case 3:
                cancelReservation(scan);
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }

    public void signUp(Scanner scan) {
        System.out.println("회원가입을 위한 아이디를 입력하세요: ");
        String id = scan.nextLine();
        scan.nextLine();

        System.out.println("회원가입을 위한 비밀번호를 입력하세요: ");
        String password = scan.nextLine();

        users.put(id, password);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void signIn(Scanner scan) {
        System.out.println("로그인을 위한 아이디를 입력하세요: ");
        String id = scan.nextLine();
        scan.nextLine();

        System.out.println("로그인을 위한 비밀번호를 입력하세요: ");
        String password = scan.nextLine();

        if(users.containsKey(id) && users.get(id).equals(password)) {
            loggedInId = id;
            System.out.println("로그인에 성공하였습니다.");
        } else {
            System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }
}