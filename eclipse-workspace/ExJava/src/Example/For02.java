package Example;

import java.util.Scanner;

public class For02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 정수 2개와 연산자 1개를 입력받아 두 정수의 연산 출력 
		 * 다른 종류의 연산자가 들어오면 잘못된 연산자라고 출력
		 */
		Scanner scan = new Scanner(System.in);
		
		int num1;
		int num2;
		char ch;
		
		System.out.println("첫번째 정수를 입력: ");
		num1 = scan.nextInt();
		System.out.println("두번째 정수를 입력: ");
		num2 = scan.nextInt();
		System.out.println("연산자를 입력: ");
		ch = scan.next().charAt(0);
		
		if((ch == '/' || ch == '%') && num2 == 0) {
			System.out.println("두번째 값은 0일수 없습니다.");
		}
		switch(ch) {
		case '+':
			System.out.println(""+num1+ch+num2+"="+(num1+num2));
			break;
		case '-':
			System.out.println(""+num1+ch+num2+"="+(num1-num2));
			break;
		case '*':
			System.out.println(""+num1+ch+num2+"="+(num1*num2));
			break;
		case '%':
			System.out.println(""+num1+ch+num2+"="+(num1%num2));
			break;
		case '/':
			System.out.println(""+num1+ch+num2+"="+(num1/num2));
			break;
			default:
				System.out.println("잘못된 연산자입니다.");
		}
		
	}

}
