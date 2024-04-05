package Example;

import java.util.Scanner;

public class For06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 단을 입력받아서 입력받은 단을 출력(구구단)
		// 2 => 2*1, 2*2 .... 2*9
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("출력할 단을 고르세요: ");
		int choose = scan.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.println(choose+"*"+i+"="+(choose*i));
		}
		
		
		
		
		
		
		
		
		
		
	}

}
