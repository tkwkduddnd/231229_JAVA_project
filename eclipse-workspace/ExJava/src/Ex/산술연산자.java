package Ex;

public class 산술연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(4+2);
		
		//연산 우선순위
		System.out.println(2+4*6);
		
		//변수를 이용한 연산
		int a=20;
		int b= 10;
		int c = a+b;
		System.out.println(c);
		c=a-b;
		System.out.println(c);
		
		//산술연산자 후반부
		int val = 10;
		System.out.println(val);
		System.out.println(val++);
		System.out.println(val);
		
		val=10;
		System.out.println(val);
		System.out.println(++val);
		System.out.println(val);
		
		val = 10;
		System.out.println(val);
		System.out.println(val--);
		System.out.println(val);
		
		val = 10;
		System.out.println(val);
		System.out.println(--val);
		System.out.println(val);
		
		//은행 대기번호 표
		
		int waiting = 0;
		System.out.println("대기 인원은: "+waiting++);
		System.out.println("대기 인원은: "+waiting++);
		System.out.println("대기 인원은: "+waiting++);
		System.out.println("총 대기 인원은: "+waiting);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
