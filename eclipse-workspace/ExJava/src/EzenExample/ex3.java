package EzenExample;

public class ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setName("k5");
		car.setColor("빨강");
		car.setYear("2024");
		car.print();
		car.speedUp();
		car.speedUp();
		car.power();
		System.out.println("내 차 시동: "+(car.isPower()? "ON":"OFF"));
		car.power();
		System.out.println("내 차 시동: "+(car.isPower()? "ON":"OFF"));
		car.speedUp();
		car.speedUp();
		System.out.println("내 차 속도: "+car.getSpeed());
		
		
		
		Car c = new Car();
		c.setName("차");
		c.setColor("빨강");
		c.setYear("2024");
		c.speedUp();
		c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();c.speedUp();
		
		System.out.println("내 차 속도: "+c.getSpeed());
		
	}

}
class Car{ //클래스 명은 대문자로 시작
	//멤버변수 - private
	//메소드 - public => getter/setter 메소드
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	
	//power()
	//꺼져있을 경우 => 켜짐
	//꺼져있을 경우 => 꺼짐
	public void power() {
		power = !power;
	}
	
	//speedUp
	public void speedUp() {
		if(speed>=300) {
			speed=300;
		}
		else {
			speed+=10;
		}
	}
	public void speedDown() {
		if(speed<=0) {
			speed=0;
		}
		else {
			speed -=10;
		}
	}
	//print()
	public void print() {
		System.out.println("내 차: "+name+", 색: "+color+", 연식: "+year);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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


