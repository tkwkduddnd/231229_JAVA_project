package new_java;
import java.util.Scanner;

public class New02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1부터10까지 중 짝수만 for문을 통해 출력
		 */
		
		for(int i = 1; i<=10; i++) {
			if(i%2==0) {
				System.out.println(i);
				
			}
		}
		System.out.println();
		
		/*
		 * 숫자를 입력받아 1부터 내가 입력한 수까지 5의 배수를 출력
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 입력: ");
		int num = scan.nextInt();
		
		for(int i = 1; i<=num; i++) {
			if(i % 5 == 0) {
				System.out.println(i);
			}
		}
		
		scan.close();

	}

}
