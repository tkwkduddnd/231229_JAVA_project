package Example;

import java.util.Scanner;

public class For05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//약수 : 나누어서 떨어지는 수의 집합
		// 6의 약수 : 6/1 =0, 6/2 = 0, 6/3 = 0 ,6/4=2, 6/5=1,6/6=0
		// 6의 약수 : 1, 2, 4, 6
		int num = 6;
		// num을 1부터 num까지 나눈 나머지가 0인 수를 출력
		for(int i = 1; i<=num; i++) {
			if(num%i==0) {
				System.out.print(i+" ");
			}
		}
			System.out.println();
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("정수를 입력하세요: ");
			int num1 = scan.nextInt();
			
			for(int i = 1;i<=num1;i++) {
				if(num1%i==0) {
					System.out.println(i+" ");
				}
				
			
			
			
			
		}
	}

}
