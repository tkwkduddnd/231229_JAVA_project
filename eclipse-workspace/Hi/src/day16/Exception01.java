package day16;

public class Exception01 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * Exception : 예외처리 
		 * 개발자가 코드 구현시 발생 할 수 있는 예외 처리하는 구문
		 * 예외가 발생하면 예외 발생 시점부터 코드 중지 => 예외문구 출력
		 * 예외처리를 하게 되면 예외가 발생할 수 있는 값만을 빼고 나머지는 정상처리
		 * 예외와 에러는 다른 기능
		 * 에러는 시스템 상에서 발생하기 때문에 개발자가 처리 불가
		 * 예외는 개발자가 처리 가능
		 * (try ~ catch) 이 둘은 같이 써야함 ~ finally 혼자 써도됨
		 * try : 예외가 발생할 가능성이 있는 구문 작성
		 * catch  : try 구문에서 발생한 예외를 처리하는 구문
		 * finally : try 구문 외에 반드시 실행돼야 하는 구문 작성
		 */
		
		try {
			System.out.println(1);
			System.out.println(2);
			System.out.println(1/0); //exception 발생 구문
			System.out.println(3);
			System.out.println(4);
		}
		catch(Exception e){ // 발생할 예외를 처리할 객체 e
			e.printStackTrace(); // 실제 예외 구문을 콘솔에 출력해줌
			System.out.println("예외가 발생");
			
		}
		
		//Exception이 발생돼도 처리됨
		System.out.println(5);
		System.out.println(6);

	}

}
