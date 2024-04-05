package day10;

public class Class02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.setName("스파크");
		c.setColor("빨간색");
		c.setYear("2024");
		
		c.print();
		c.power();
		System.out.println("mycar power: "+(c.isPower()? "On":"Off"));
		c.power();
		System.out.println("mycar power: "+(c.isPower()? "On":"Off"));
		
		Car c1 = new Car();
		c1.setName("그렌저");
		c1.setColor("검정");
		c1.setYear("2003");
		c1.print();
		c1.power();
		System.out.println("mycar1 power: "+(c.isPower()? "On":"Off"));
		System.out.println("mycar1 power: "+(c.isPower()? "On":"Off"));
		c.speedUp();
		c.speedUp();
		c.speedUp();
		
		
		
		
		/*c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		
		System.out.println("mycar speed:"+c.getSpeed());
		*/
	}

}
class Car{
	
	//클래스 명은 대문자 시작
	//멤버변수는 private으로 설정
	//메소드는 public으로 설정 => getter setter도 메소드
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	//power()
	//꺼져있을 때 -> 켜짐
	//켜져 있을 때 -> 꺼짐
	public void power() {
		power=!power;
	
	
}
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
		speed-=10;
	}
	}
	
	public void print() {
		System.out.println("mycar: "+name+"/"+color+"("+year+")");
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
	
	
	//speedUp()
	
		//speedDown()
		
		//print()
