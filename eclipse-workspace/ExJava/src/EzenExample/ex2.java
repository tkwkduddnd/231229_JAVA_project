package EzenExample;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 클래스의 구성요소 : 멤버변수, 메소드
		 * 멤버변수가 먼저, 메소드가 뒤에 선언
		 * 
		 * 클래스 - 설계도
		 * 객체 - 제품
		 * 메소드 - 기능
		 * 
		 * 클래스의 구성요소 : 멤버변수, 메소드
		 * -멤버변수 (속성, 정보)
		 * -메소드(기능)
		 * 
		 * 프린터 클래스
		 * -속성(멤버변수): 크기, 색, 제조사, 제품명, 종류
		 * -기능(메소드): 인쇄, 복사, 스캔, 팩스
		 * 
		 * 멤버변수는 클래스 안 가장 위쪽에 작성 / 메소드는 멤버변수 뒤에 선언
		 * 멤버변수는 클래스 안에서 사용가능, (모든 메소드에서 공통적으로 사용가능)
		 * 
		 * -객체 선언
		 * 클래스명 객체명;// 선언만 값은 null
		 * 객체명 = new 클래스명(); // 선언한 객체의 초기값 설정
		 * 
		 * 
		 * -객체 선언(초기화 생성)
		 * 클래스명 객체명 = new 클래스명();
		 * 
		 * -메소드 사용법(클래스가 다른 메소드를 호출할 경우)
		 * 객체 선언 후 객체명.메소드명();
		 * 
		 * -같은 클래스 안에서 메소드를 호출할 경우 =>메소드명();
		 * -다른 클래스 안에서 메소드를 호출할 경우 => 객체명.메소드명();
		 * 
		 */
		
		
	}
}

class Point{
	//멤버변수 위치
	//멤버변수는 초기값을 설정하지 않아도 자동으로 설정
	//int 0으로 설정, String은 null로 자동설정
	private int x;
	private int y;
	
	public void print() {
		System.out.println("("+x+","+y+")");
	}
	
	//포인트 값을 저장하는 메소드
	public void save(int x, int y) {
		//this : 멤버변수를 지칭하는 키워드
		this.x=x;
		this.y=y;
	}

	//getter (데이터를 가져오는 메소드)
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	//setter  (데이터를 변경하는 메소드)
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
