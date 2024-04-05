package Example;

public class If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 조건문: if문 , switch문
		 * if(조건식){실행문;}
		 * 실행문이 한줄일 경우 {} 생략 가능
		 * 실행문이 2줄 이상일 경우 반드시 {} 사용
		 * 조건식은 반드시 true/false 형태로 나올 수 있게 작성
		 * 
		 */
		int num = -1;
		
		if(num>0) {
			System.out.println("양수입니다.");
		}
		//num이 0보다 크면 양수입니다. 작으면 음수입니다.
		if(num>0) {
			System.out.println("양수입니다.");
		}
		else {
			System.out.println("음수입니다.");
		}
		
		//num이 0보다 크면 양수/ 아니면 음수/ 0이면 0입니다. 출력
		if(num>0) {
			System.out.println("양수");
		}
		else if(num<0) {
			System.out.println("음수");
		}
		else {
			System.out.println("0입니다.");
		}
		System.out.println("-----------------");
		
		//num이 0보다 크면 양수 (10보다 크면 10보다 큽니다.) / 아니면 음수 / 0이면 0입니다. 출력
		if(num>0) {
			System.out.println("양수");
		}
		if(num>10) {
			System.out.println("10보다 큽니다");
		}
		else if(num<0) {
			System.out.println("음수");
		}
		else {
			System.out.println("0입니다.");
		}
		
		//num2 변수를 선언한 후 num2가 짝수인지 홀수인지 출력
		
		int num2 = 9;
		if(num2%2==0) {
			System.out.println("짝수");
		}
		else {
			System.out.println("홀수");
		}

	}

}
