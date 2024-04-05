package exex;

import java.util.Scanner;

public class stdMain {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		stdManager sm = new stdManager();
		
		int menu = 0;
		do {
			System.out.println("-------------------------------");
            System.out.println("1.학생 등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보, 수강정보, 성적)");
            System.out.println("4. 수강신청 | 5. 수강철회 | 6. 성적 추가 | 7. 성적 삭제 | 8. 성적 수정 | 9. 성적 출력 | 10. 종료");
            System.out.println("-------------------------------");

            System.out.print("선택: ");
            menu = scan.nextInt();
            
            switch(menu) {
            case 1:
            	sm.addStd(scan);
            }
		}
		while(menu !=9);
			System.out.println("틀림");
		
	}
}
