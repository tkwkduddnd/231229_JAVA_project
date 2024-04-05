// 패키지 선언. EzenExample이라는 이름의 패키지를 생성.
package EzenExample;

public class ex4 {

	public static void main(String[] args) {
		// Car1 클래스의 객체 c를 생성. 이 때 생성자는 아무런 매개변수가 없는 기본 생성자를 호출.
		Car1 c = new Car1();
		// 생성한 객체 c의 name 필드에 "카니발"을 저장.
		c.setName("카니발");
		// 생성한 객체 c의 year 필드에 "2024"를 저장.
		c.setYear("2024");
		// 생성한 객체 c의 color 필드에 "빨강"을 저장.
		c.setColor("빨강");
		// 생성한 객체 c의 door 필드에 "4개"를 저장.
		c.setDoor("4개");
		// 생성한 객체 c의 printInfo() 메소드를 호출하여 객체 c의 정보를 출력.
		c.printInfo();
		// 생성한 객체 c의 power() 메소드를 호출하여 power 필드의 값을 변경 (시동 켜기).
		c.power();
		// 생성한 객체 c의 speedUp() 메소드를 세 번 호출하여 speed 필드의 값을 30 증가.
		c.speedUp();
		c.speedUp();
		c.speedUp();
		// 생성한 객체 c의 power() 메소드를 호출하여 power 필드의 값을 변경 (시동 끄기).
		c.power();
	}
}

// Car1 클래스 선언.
class Car1{
	
	// 멤버 변수 선언. 차량의 이름, 제조 연도, 색상, 문 개수, 시동 상태, 속도를 저장.
	private String name;
	private String year;
	private String color;
	private String door;
	private boolean power;
	private int speed;
	
	// 기본 생성자. 아무런 동작을 하지 않음.
	public Car1(){
	}
	
	// 생성자 오버로딩. name, year, color, door 매개변수를 받아 멤버 변수를 초기화.
	public Car1(String name, String year, String color, String door) {
		// 또 다른 생성자 호출. name과 year 매개변수를 전달.
		this(name, year);
		// color, door 멤버 변수 초기화.
		this.color = color;
		this.door = door;
	}
	
	// 생성자 오버로딩. name과 year 매개변수를 받아 멤버 변수를 초기화.
	public Car1(String name, String year) {
		// name, year 멤버 변수 초기화.
		this.name = name;
		this.year = year;
	}
	
	// 차량의 정보를 출력하는 메소드. name, year, color, door 정보를 출력.
	public void printInfo() {
		System.out.println(name+"("+year+")");
		System.out.println(color+"("+door+")");
	}
	
	// 차량의 시동 상태를 변경하는 메소드. 시동 상태에 따라 다른 메시지를 출력.
	public void power() {
		// power 필드의 값을 반전. true면 false로, false면 true로 변경.
		this.power = !power;
		// 시동이 켜져 있고 속도가 0이하면 시동이 켜졌다는 메시지 출력.
		if(this.power && speed <=0) {
			System.out.println("시동이 켜졌습니다.");
		}
		// 시동이 켜져 있고 속도가 0 초과면 주행 중이라는 메시지 출력.
		else if(this.power && speed >0) {
			System.out.println("주행중입니다.");
		}
		// 시동이 꺼져 있고 속도가 0 초과면 시동을 끌 수 없다는 메시지 출력.
		else if(!power && speed > 0) {
			System.out.println("주행 중에는 시동을 끌 수 없습니다.");
		}
		// 그 외의 경우에는 시동이 꺼졌다는 메시지 출력.
		else {
			System.out.println("시동이 꺼졌습니다.");
			// power 필드를 false로 설정.
			this.power = false;
		}
	}
	
	// 속도를 증가시키는 메소드. 시동 상태와 현재 속도에 따라 다른 동작을 수행.
	public void speedUp() {
		// 시동이 꺼져 있으면 시동을 켜라는 메시지 출력.
		if(!power) {
			System.out.println("시동이 꺼져있습니다. 시동을 켜주세요");
		}
		else {
			// 속도가 300 이상이면 최고속도라는 메시지 출력하고 속도를 300으로 설정.
			if(speed>=300) {
				speed=300;
				System.out.println("최고속도입니다.");
			}
			// 그 외의 경우에는 속도를 10 증가시키고 현재 속도를 출력.
			else {
				speed+=10;
				System.out.println("현재속도: "+speed);
			}
		}
	}
	
	// 속도를 감소시키는 메소드. 시동 상태와 현재 속도에 따라 다른 동작을 수행.
	public void speedDown() {
		// 시동이 켜져 있으면
		if(power) {
			// 속도가 0 이하면 멈춰있다는 메시지를 출력하고 속도를 0으로 설정.
			if(speed<=0) {
				System.out.println("멈춰있습니다.");
				speed=0;
			}
			// 그 외의 경우에는 속도를 10 감소시키고 현재 속도를 출력.
			else {
				speed -=10;
				System.out.println("현재 속도: "+speed);
			}
		}
		// 시동이 꺼져 있으면 시동이 꺼져있다는 메시지 출력.
			else {
				System.out.println("시동이 꺼져있습니다.");
			}
	}

	// 각 멤버 변수의 getter와 setter 메소드.
	// getter 메소드는 해당 필드의 값을 반환.
	// setter 메소드는 매개변수로 받은 값을 해당 필드에 저장.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		this.door = door;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
