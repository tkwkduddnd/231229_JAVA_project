package day10;

public class Class01 {
	/*클래스의 구성요소 : 멤버변수, 메소드
	 * 멤버변수가 먼저, 메소드가 뒤에
	 * 클래스 - 설계도, 
	 * 객체 - 제품, 
	 * 메소드 - 객체가 할 수 있는 기능
	 * 멤버변수(속성, 정보)
	 * 메소드 (기능)
	 * 
	 * 프린터 클래스
	 * 속성(멤버변수): 크기, 색깔, 제조사, 제품명, 종류
	 * 기능(메소드): 인쇄, 복사, 스캔, 팩스
	 * 
	 * 멤버변수: 클래스 안 가장 위쪽 작성
	 * 메소드: 멤버변수 뒤에 선언
	 * 멤버변수는 클래스 안에서 사용가능(모든 메소드에서 공통 사용 가능)
	 * 
	 * 객체 선언
	 * 클래스명 객체명; //선언만 하면 값은 null
	 * 객체명 = new 클래스명(); //선언한 객체의 초기값 설정
	 * 
	 * 객체 선언(초기화 생성)
	 * 클래스명 객체명 = new 클래스명();
	 * 
	 * 메소드 사용법 (클래스가 다른 메소드를 호출할 경우)
	 * 객체 선언 후 객체명.메소드명();
	 * 
	 * 같은 클래스 안에서 메소드를 호출한 경우=> 메소드명();
	 * 다른 클래스에서 메소드 호출할 때 => 객체명.메소드명();
	 * 
	 * 
	 * 접근제한자
	 * - public: 모두 사용가능
	 * - protected: 나+패키지+나를 상속받는 자식 클래스
	 * - default: 나 + 패키지
	 * - private: 나
	 * 클래스에서 public을 붙일 수 있는 건 파일명과 클래스명이 같을때만 가능
	 * 한 파일안에 하나의 클래스만 가능한건 아님
	 * 멤버변수와 멤버메소드 public 붙이는거 상관없음
	 * 일반적으로 멤버변수는 private으로 선언
	 * 메소드는 public으로 선언
	 * private은 다른 클래스에서 접근 x
	 * private으로 선언된 멤버변수는 getter / setter 메소드를 별도로 생성해서 
	 * 해당 변수에 접근한다
	 */
	public static void main(String[] args) {
		Point p = new Point();
		p.print();
		//멤버변수 private 해줘서 직접 접근 불가능
		//p.x=1;
		//p.y=2;
		p.setX(1);
		p.setY(2);
		p.print();
		p.save(10,20);
		System.out.println(p.getX());
		System.out.println(p.getY());
		p.setX(p.getX()+p.getY());
		System.out.println(p.getX());
		
		p.setY(50);
		System.out.println(p.getY());
		//현재 x와 y값을 합쳐서 x,y값을 합으로 설정하고 
	}
}
//클래스 생성시 클래스 밖에서 생성
//(1,0)(x,y)
class Point{
	//멤버변수 위치
	//멤버변수는 초기값 설정 안해도 자동 설정
	//int 값이면 0으로 설정, String은 null값
	
	private int x;
	private int y;
	
	String x1;
	String y1;
	
	public void print() {
		System.out.println("("+x+","+y+")");
		
		
		
	}
	//point값을 저장하는 메소드
	
	public void save(int x, int y) {
		//this는 멤버변수를 지칭하는 키워드
		this.x=x;
		this.y=y;
		System.out.println("("+x+","+y+")");
	}
	
	//getter(데이터 가져오는 메소드)
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	//setter(데이터 변경하는 메소드)
	public void setX(int x) {
		this.x = x;
		
	}
	public void setY(int y) {
		this.y= y;
	}
}
