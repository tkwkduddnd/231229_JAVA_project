package day13;

public class 추상클래스01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 추상 클래스는 미완성 클래스
		 * 추상 메소드는 메소드의 선언부만 있고, 구현은 없음
		 * 추상 클래스는 추상 메소드를 포함하고 있음
		 * 추상 클래스는 미완성 클래스라서 객체 생성 불가
		 * 키워드 : abstract
		 * ex) abstract 클래스명 / abstract 메소드명
		 * abstract 리턴타입 메소드명(매개변수); => 추상메소드
		 * - 추상 클래스에서 abstract 키워드 생략 불가
		 * 인터페이스는 abstrct 생략 가능( 추상메소드만 존재)
		 * 상속을 받아야하는 부모 클래스를 작성할 경우
		 * 특정 메소드가 자식들에게 자주 오버라이딩 되는 경우
		 * 상속 받은 클래스에 추상메소드가 있다면 무조건 구현해야함
		 * 
		 */
		Dog1 dog = new Dog1("뽀삐","개");
		dog.printInfo();
		dog.howl();
		dog.eating("개껌");
		
		Cat1 cat = new Cat1("나비", "고양이");
		cat.printInfo();
		cat.howl();
		cat.eating("츄르");
	}

}
//추상 클래스: 키워드 -> abstract
abstract class Animal1{
	public String name;
	public String category;
	
	public void printInfo() {
		System.out.println("이름: "+name+", 종:"+category);
	}
	abstract public void howl();
}
class Dog1 extends Animal1{
	
	private String eat;
	public Dog1(String name, String category) {
		super.name = name;
		super.category = category;
		
	}

	@Override
	public void howl() {   //반드시 구현해야함
		// TODO Auto-generated method stub
		System.out.println(name+"울음소리 : 멍멍");
	} 
	
	public void eating(String eat) {
		this.eat = eat;
		System.out.println(name+"은"+eat+"을 좋아합니다");
	}
	
	
	
	
}

class Cat1 extends Animal1{
	private String eat;
	
	public Cat1(String name, String category) {
		super.name = name;
		super.category = category;
	}

	@Override
	public void howl() {
		// TODO Auto-generated method stub
		System.out.println(name+"의 울음소리: 야옹");
		
		
	}
	public void eating(String eat) {
		System.out.println(name+"이 좋아하는 음식: "+eat);
	}
	
}