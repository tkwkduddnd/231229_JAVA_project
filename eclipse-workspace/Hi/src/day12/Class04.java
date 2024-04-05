package day12;

public class Class04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* static
		 * 
		 *  객체의 생성없이 클래스가 만들어지면 생성
		 *  객체없이 클래스만으로 사용가능
		 *  클래스명.메소드 / 클래스명.멤버변수
		 *  객체를 생성해서 호출도 가능하지만 그렇게 사용하지 않음
		 *  클래스의 멤버변수/메소드는 하나의 멤버변수가 모든 객체에 공유(사용)할 떄 사용
		 *  
		 * static이 붙은 메소드/멤버변수 클래스 멤버변수/메소드 라고한다
		 * static이 안붙은 메소드/멤버변수는 객체(인스턴스)의 멤버변수/메소드 라고함
		 * 객체의 멤버변수/메소드는 객체를 통해 사용되고, 생성(객체 안만들면 생성 X)
		 * 객체.메소드, 객체.멤버변수
		 * 각 객체마다 독립적인 객체 => 각 객체마다 독립적인 멤버변수, 메소드 생성
		 * 
		 * 클래스 / 객체는 생성 시점이 달라서 메소드를 사용 할 수 있는 환경이 다름
		 * 객체의 멤버는 클래스가 생성되고 난 후 객체를 생성 할 수 있음
		 * 클래스 멤버는 클래스의 멤버 안에서만 사용 가능(변수/메소드)
		 * 
		 */
		Tv.printBrand();//클래스명.메소드명(); 호출
		
		Tv t = new Tv();
		t.printPower(); //객체 메소드 사용 객체명.메소드명();
		t.printBrand(); // 객체를 통해 클래스 멤버에 접근할 수 있지만, 그렇게 사용안함
		}
}
	class Tv {
		private boolean power;
		private final static String BRAND = "LG";
		
		//power를 출력하는 메소드
		
		public void printPower() {
			if(power) {
				System.out.println("티비가 켜짐");
			}
			else {
				System.out.println("티비가 꺼짐");
			}
			//객체 메소드에서 클래스 변수 사용 가능
			//클래스의 멤버는 어디서든 사용 가능
		}
		public static void printBrand() {
			System.out.println("브랜드: "+BRAND);
			//클래스 메소드에서는 객체변수 사용 불가
	}
	
	}


	
	
	
