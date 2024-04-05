package day15;
/*
 * 객체지향 프로그래밍의 4가지 특징
 * 프로그램을 독립된 단위의 객체들을 모아서 처리하는 모임
 * 각각의 객체는 메세지를 주고 받으면서 데이터를 처리
 * 추상화, 캡슐화(정보 은닉), 상속, 다형성
 * 
 * 추상화(Abstraction) : 핵심적인 코드만 보여주기
 * 구현된 부분과 구현되지 않은 부분으로 분리
 * 불필요한 부분을 숨김
 * 
 * 캡슐화(Encapsulation) : 데이터 보호(정보 은닉)
 * 멤버변수(필드)는 숨기고, 메소드로 접근
 * 멤버변수와 메소드를 하나로 묶어서 처리
 * 은닉화 : 객체의 내부의 정보는 숨겨 외부로 드러나지 않게 하는 것
 * 외부에서 데이터에 직접 접근하는 것을 방지
 * 
 * 상속(Inheritance): 코드 재사용(확장)
 * 클래스를 상속받아 수정하여 사용하면 중복 코드를 줄일 수 있음
 * 유지보수가 편함
 * 
 * 다형성(Polymorphism) : 객체 형변환 용이
 * 하나의 코드가 여러 자료(객체)형으로 구현되어 실행되는 것
 * 코드는 같은데 들어오는 객체에 따라 다른 실행결과를 얻을 수 있음
 * 다형성을 잘 활용하면 유연하고, 확장성 잇는, 유지보수가 편리한 프로그램 만들수 있음
 */


class Animal{
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal{
	public void move() {
		System.out.println("사람은 두발로 걷습니다.");
	}


public void readBook(){
	System.out.println("사람이 책을 읽습니다.");
	
}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이는 네 발로 걷습니다.");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
	
}

class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}
	public void flying() {
		System.out.println("독수리가 비행합니다.");
	}
}

class Dog{
	public void move() {
		System.out.println("강아지가 걷는다");
	}
}
public class 다형성01 {

	public static void main(String[] args) {
		/*
		 * Human, tiger, eagle 객체 생성
		 */
		
		Human h = new Human();
		h.move();
		Tiger t = new Tiger();
		Eagle e = new Eagle();
		
		
		//조상의 클래스로 자식의 객체 생성 가능
		//조상의 클래스에서 상속받은 것만 실행가능
		Animal hAnimal = new Human();
		hAnimal.move();
		Animal tAnimal = new Tiger();
		hAnimal.move();
		Animal eAnimal = new Eagle();
		eAnimal.move();
		
		System.out.println("-----------------------");
		
		
		다형성01 ex1 = new 다형성01();
		//ex1.moveAnimal(h);
		//ex1.moveAnimal2(t);
		//ex1.moveAnimal3(e);
		
		//부모의 객체로 생성되었기 때문에 가능
		ex1.moveAnimal(hAnimal);
		ex1.moveAnimal(tAnimal);
		ex1.moveAnimal(eAnimal);
		ex1.moveAnimal(h);
		ex1.moveAnimal(t);
		ex1.moveAnimal(e);
		
		
		
		Dog d = new Dog();
		d.move();
		
		System.out.println("--------------------------");
		
		//ex1.moveAnimal(dog); //Animal 클래스에 상속받고 있지 않아서 사용 불가
		
		System.out.println("--------------------------");
		System.out.println("animal 배열 생성예시----------");
		
		Animal[] aniList = new Animal[5];
		int cnt = 0;
		aniList[cnt] = hAnimal;
		cnt++;
		aniList[cnt] = tAnimal;
		cnt++;
		aniList[cnt] = eAnimal;
		cnt++;
		
		for(int i = 0; i<cnt;i++) {
			aniList[i].move();
		}
		System.out.println();
		System.out.println("------다운캐스팅 예시-----------");
		
		Human human = (Human)hAnimal; //Human 을 담을 수 있는 자료형의 객체 : Animal을 상속받은 
		                              //휴먼 클래스 객체를 담은 케이스
		
		human.readBook();
		
		//다운 캐스팅의 잘못된 예시
		//Human human1 = (Human)tAnimal;
		
		//human1.readBook();
		
		
		//instanceof : 객체가 해당 클래스의 형에 맞는지 체크하는 연산자
		System.out.println("----instanceof---");
		System.out.println(tAnimal instanceof Human);
		System.out.println(tAnimal instanceof Tiger);
		System.out.println(tAnimal instanceof Eagle);
		
		
		Animal downCastingTest = eAnimal;
		if(downCastingTest instanceof Human) {
			Human testHuman = (Human)downCastingTest;
			testHuman.readBook();
		}
		else if(downCastingTest instanceof Tiger) {
			Tiger testTiger = (Tiger)downCastingTest;
			testTiger.hunting();
		}
		else if(downCastingTest instanceof Eagle) {
			Eagle testEagle = (Eagle)downCastingTest;
			testEagle.flying();
		}
		else {
			System.out.println("error");
		}
		
	}
	
	
	//각 객체의 move를 실행해주는 메소드 생성
	
	/*public void moveAnimal(Human human) {
		human.move();
	}
	public void moveAnimal2(Tiger tiger) {
		tiger.move();
	}
	public void moveAnimal3(Eagle eagle) {
		eagle.move();
	}*/
	
	
	//다형성의 예시(업케스팅: 자동 형변환 기능)
	public void moveAnimal(Animal animal) {
		animal.move();
	}

}
