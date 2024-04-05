package Example;

import java.util.Scanner;

public class If03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 콘솔 입력: 콘솔에서 값을 입력받는 것을 의미
		 * Scanner 클래스 => 콘솔에서 값을 입력받을 수 있게 해주는 클래스
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자(정수)를 입력해주세요: ");
		int num = scan.nextInt();
		System.out.println("내가 입력한 수 : "+num);
		
		if(num%2 ==0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		
		System.out.println("--------------------");
		
		System.out.println("실수 입력: ");
		double num2 = scan.nextDouble();
		System.out.println("내가 입력한 실수: "+num2);
		
		System.out.println("--------------------");
		System.out.println("한글자만 입력: ");
		//문자열 입력: next() /charAt(index) : 문자열중 index 번지의 한글자를 추출
		char ch = scan.next().charAt(0);
		System.out.println("내가 입력한 글자:"+ch);
		
		System.out.println("--------------------");
		System.out.println("한 단어 입력: ");
		String s = scan.next();
		System.out.println("내가 입력한 단어: "+s);
		
		System.out.println("--------------------");
		scan.nextLine();
		
		
		System.out.println("--------------------");
		System.out.println("여러단어 : ");
		String str = scan.nextLine();
		System.out.println("내가 입력한 단어: "+str);
		
		scan.close();
	}

}
