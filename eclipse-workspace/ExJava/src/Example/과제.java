package Example;

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 정수 2개와 연산자 1개를 입력받아 두 정수의 연산을 출력
		 * ex) 2 3 + => 2 + 3 => 5
		 * 
		 * 연산자는 + - * / % 가능
		 *	다른 종류의 연산자가 들어오면 잘못된 연산자로 출력
		 *
		 *
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 정수 입력: ");
		int num = scan.nextInt();
		
		System.out.println("두번째 정수 입력: ");
		int num1 = scan.nextInt();
		
		System.out.println("연산자 입력: ");
		char ch = scan.next().charAt(0); //한글자 받기
		
		// /, %일 경우 num2가 0이 되면 안내문구 띄우기
		if((ch == '%' || ch == '/') && num1 ==0) {
			System.out.println("잘못된 값입니다.");
		}
		else {
			int a = num - num1;
			int b = num * num1;
		
		switch(ch) {
		case '+': 
			System.out.println(""+num+ch+num1+"="+(num+num1));
			break;
		case '-':
			System.out.println(""+num+ch+num1+"="+a);
			break;
		
		case '*':
			System.out.println(""+num+ch+num1+"="+b);
		break;
		case '/':
			//if(num1==0) {
			//System.out.println("잘못된 입력값입니다.");
			//}
			//else {
				System.out.println(""+num+ch+num1+"="+(num/(double)num1));
			//}
			break;
		case '%':
			System.out.println(""+num+ch+num1+"="+(num%num1));
			break;
			default:
				System.out.println("없는 연산자 입니다");
				break;
		}
		}
		scan.close();
		
		
		
		
		
		
		
	}

}
