package Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Hospital.ViewDepartmentManager;

public class HospitalManager {
	Scanner scan = new Scanner(System.in);
	
	Map<String, String> users = new HashMap<>();
	Map<String, List<String>> userReserv = new HashMap<>();
	String loggedInId = null;
	
	
	public void medicalReserv(Scanner scan) {
		System.out.println("이름을 입력하세요: ");
        String name = scan.nextLine();
            
        System.out.println("나이를 입력하세요: ");
        int age = scan.nextInt();

        System.out.println("성별을 입력하세요.(남자/여자)");
        String gender = scan.nextLine();
        
        System.out.println("전화번호를 입력하세요: ");
        String phone = scan.nextLine();

        ViewDepartmentManager viewDepartmentManager = new ViewDepartmentManager();
        String department = viewDepartmentManager.viewDepartment(scan);

        String reservation = "이름: "+name+", 나이: "+age+", 성별: "+gender+", 전화번호: "+phone;
        reservation += ", 진료과: " + department;

        // 예약 정보를 맵에 저장
        List<String> reservations;
        if (userReserv.containsKey(loggedInId)) {
            reservations = userReserv.get(loggedInId);
        } else {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        userReserv.put(loggedInId, reservations);
		
	}
	public void viewReserv(Scanner scan) {
		List<String> reservations = userReserv.get(loggedInId);
	    if (reservations == null || reservations.isEmpty()) {
	        System.out.println("예약 내역이 없습니다.");
	    } else {
	        System.out.println("예약 내역:");
	        int count = 1;
	        for (String reservation : reservations) {
	            System.out.println(count + ". " + reservation);
	            count++;
	        }
	    }
	}
	public void modifyReserv(Scanner scan) {
		List<String> reservations = userReserv.get(loggedInId);
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
	public void cancelReserv(Scanner scan) {
		List<String> reservations = userReserv.get(loggedInId);
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
		
	}
	public void sendNotification(Scanner scan) {
		List<String> reservations = userReserv.get(loggedInId);
        if (reservations == null || reservations.isEmpty()) {
            System.out.println("예약 내역이 없어 알림을 보낼 수 없습니다.");
        } else {
            System.out.println("예약 알림을 모든 사용자에게 발송하였습니다.");
        }
	}
	public void manageReserv(Scanner scan) {
		System.out.println("예약 내역을 관리합니다. 다음 중 하나를 선택하세요:");
        System.out.println("1. 예약 조회\n2. 예약 수정\n3. 예약 취소");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                viewReserv(scan);
                break;
            case 2:
                modifyReserv(scan);
                break;
            case 3:
                cancelReserv(scan);
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
	
	


