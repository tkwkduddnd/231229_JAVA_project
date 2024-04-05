package day17;



interface power{
	void turnOn();
	void turnOff();
}

//class Tv implements power {
//
//	@Override
//	public void turnOn() {
//		// TODO Auto-generated method stub
//		System.out.println("Tv를 켭니다.");
//	}
//
//	@Override
//	public void turnOff() {
//		// TODO Auto-generated method stub
//		System.out.println("Tv를 끕니다.");
//	}
//	
//}

public class 익명클래스 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * 익명클래스: 이름이 없는 클래스
		 * 인터페이스를 이용해서 객체를 만들 때 클래스 구현 없이
		 * 바로(매개변수로) 구현
		 * 익명클래스를 사용하는 이유
		 * - 인터페이스의 기능이 적고. 해당 객체가 하나만 필요한 경우
		 * 메소드의 매개변수로 주로 사용
		 */
		
		//매개변수로 인터페이스를 구현한 객체가 필요한 경우
		//1.인터페이스를 구현한 구현 클래스 생성
		//2.구현 객체 생성
		//3. 매개변수로 값을 줌
		익명클래스 ex = new 익명클래스();
//		Tv t = new Tv();
//		ex.product(t);
		
		
		// 익명 클래스로 작업하는 경우
		ex.product(new power() {

			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("전원을 켭니다");
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("전원을 끕니다");
			}
			
		});

	}
	public void product(power p) {
		p.turnOn();
		System.out.println("적상 작동중");
		p.turnOff();
		System.out.println("꺼짐");
	}

}
