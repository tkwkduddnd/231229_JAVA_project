package Std;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		/*
		 * 메뉴 구성
		 * 1. 학생 추가 2. 학생 리스트 3. 학생 검색
		 * 4. 학생 수정 5. 학생 삭제 6. 점수 추가
		 * 7. 점수 수정 8. 점수삭제 9. 종료
		 */
		Scanner scan = new Scanner(System.in);
		StudentManager stdm = new StudentManager();
		
		stdm.add();
		
		int menu = 0;
		
		do {
			System.out.println("----------------------------");
			System.out.println("메뉴 구성");
			System.out.println("1. 학생 추가 | 2. 학생 리스트 | 3. 학생 검색");
			System.out.println("4. 학생 수정 | 5. 학생 삭제 | 6. 점수 추가");
			System.out.println("7. 점수 수정 | 8. 점수 삭제 | 9. 종료");
			System.out.println("----------------------------");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				stdm.addStd(scan);
				break;
			case 2:
				stdm.printStd();
				break;
			case 3:
				stdm.searchStd(scan);
				break;
			case 4:
				stdm.modStd(scan);
				break;
			case 5:
				stdm.delStd(scan);
				break;
			case 6:
				stdm.addSub(scan);
				break;
			case 7:
				stdm.modsub(scan);
				break;
			case 8:
				stdm.delSub(scan);
				break;
			case 9:
				System.out.println("종료되었습니다.");
				break;
				default:
					System.out.println("잘못된 선택입니다.");
			}
		}
	
		while(menu !=9);
			System.out.println("프로그램 종료");
		
			scan.close();
		}

}


