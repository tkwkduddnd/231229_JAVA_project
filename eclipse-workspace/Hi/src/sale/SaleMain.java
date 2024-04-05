package sale;

import java.util.Scanner;

import day19.SaleManager;

public class SaleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. 메뉴 추가 | 2. 메뉴 삭제 | 3. 매뉴 수정(가격수정)
		 * 4. 메뉴보기(전체메뉴출력) | 5. 주문 | 6. 주문내역출력(영수증) | 7. 종료
		 */
		
		Scanner scan = new Scanner(System.in);
		
		SaleManager sm = new SaleManager();
		
		int menu = -1;
		
		do {
			System.out.println("1. 메뉴 추가 | 2. 메뉴 삭제 | 3. 메뉴수정(가격수정)");
			System.out.println("4. 메뉴보기(전체메뉴 출력) | 5. 주문 | 6. 주문내역출력(영수증) | 7. 종료");
			System.out.println("선택: ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				sm.add(scan);
				break;
			case 2:
				sm.menuDelete(scan);
				break;
			case 3:
				sm.menuModify(scan);
				break;
			case 4:
				sm.menuPrint();
				break;
			case 5:
				System.out.println("주문메뉴: ");
				String name = scan.next();
				System.out.println("수량: ");
				int count = scan.nextInt();
				sm.orderPick(name, count);
				break;
			case 6:
				sm.orderPrint();
				break;
			default:
				System.out.println("잘못된 선택");
				break;
				
			}
		}
		while(menu != 7);
		System.out.println("프로그램 종료");
		
		
		scan.close();
		
		
		
		
	}

}
