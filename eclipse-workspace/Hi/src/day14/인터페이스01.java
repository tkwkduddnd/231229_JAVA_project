package day14;

public class 인터페이스01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 인터페이스 : 추상메소드와 상수(final)로만 이루어진것
		 * 추상메소드 : 메소드의 선언부만 있고, 구현부가 없는 메소드
		 * 추상클래스 / 인터페이스 : 반드시 구현을 해야 객체를 생성 가능
		 * 
		 * 인터페이스 키워드 : interface
		 * 기능 요약서 : 매뉴얼 화
		 * 
		 * 자체적으로 사용 불가, 인터페이스를 구현한 클래스가 있어야함
		 * 구현 키워드 : implepent
		 * 인터페이스는 멤버변수가 없음
		 * 
		 * 
		 */
		
		Tv Tv = new Tv();
		Tv.turnOn();
		Tv.turnOff();
		Tv.channelUp();
		Tv.channelUp();
		Tv.channelUp();
		Tv.channelUp();
		Tv.channelDown();
	}

}

interface Power {
	abstract void turnOn();
	abstract void turnOff();
}

interface Remocon {
	void volUp();
	void volDown();
}

/*class Tv extends A, implement B{ //상속과 구현을 하는 케이스
	
}*/
	
//인터페이스 구현

class Tv implements Power, Remocon { //인터페이스를 구현할 클래스
	private boolean power;
	private int vol;
	private int channel;
	@Override
	public void turnOn() { //전원 켜기
		// TODO Auto-generated method stub
		power = true;
		System.out.println("전원이 켜짐");
	}

	@Override
	public void turnOff() { // 전원 끄기
		// TODO Auto-generated method stub
		power = false;
		System.out.println("전원 꺼짐");
	}
	
	public void channelUp() {
		if(power) {
			channel++;
			System.out.println("채널: "+channel);
		}
		
	}
	public void channelDown() {
		if(!power) {
			channel--;
			System.out.println("채널: "+channel);
		}
	}

	@Override
	public void volUp() {
		// TODO Auto-generated method stub
		if(power) {
			vol++;
			System.out.println("볼륨: "+vol);
		}
	}

	@Override
	public void volDown() {
		// TODO Auto-generated method stub
		if(!power) {
			vol--;
			System.out.println("볼륨: "+vol);
		}
	}
	
}
