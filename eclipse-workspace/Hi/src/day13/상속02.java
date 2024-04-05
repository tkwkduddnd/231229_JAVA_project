package day13;

class Animal {
	private String name; // 이름
	private String category; //동물 종
	private String howl;
	
	public Animal() {}
		
		public Animal(String name, String category) {
			this.name = name;
			this.category = category;
			
		}
		
		public void print() {
			System.out.println("종: "+category+"이름: "+name+"울음소리: "+howl);
			
		}
		public void printInfo() {
			System.out.println("이름: "+name);
			System.out.println("종: "+category);
		}
		public void howl() {
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
	
}
//Dog Cat Animal 클래스 상속
class Dog extends Animal{
	public Dog() {
		setName("강아지");
		setCategory("개");
	}
	@Override
	public void howl() {
		super.howl();
		System.out.println("멍멍");
	}
	
	
}
class Cat extends Animal{
	public Cat(String name, String category) {
		super.setName(name);
		super.setCategory(category);
	}
	public void howl(){
		super.howl();
		System.out.println("야옹");
		
	}

	
}
class tiger extends Animal{
	public tiger(String name, String category) {
		//super 생성자 호출
		super(name,category);
	}
	@Override
	public void howl() {
		super.howl();
		System.out.println("어흥");
	}
}


public class 상속02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * 오버라이딩 : 부모 클래스에 물려받은 메소드를 재정의 함
		 * 부모 클래스의 메소드와 선언부가 일치해야함
		 * 접근제한자도 더 넓은 범위는 가능하지만, 축소는 안됨
		 */
		Animal animal = new Animal();
		
		
		Dog dog = new Dog();
		dog.printInfo();
		dog.howl();
		
		
		Cat cat = new Cat("나비", "고양이");
		cat.printInfo();
		cat.howl();
		
		tiger t = new tiger("호랭이", "고양이");
		t.printInfo();
		t.howl();

	}

}
