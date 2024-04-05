package day10;

public class 과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//멤버변수 : name, year, color, door(문 개수), power, speed
		//내 차량의 정보를 출력하는 메소드 (name, year, color, door)
		
		//power() 켜지면 켜졌다고, 꺼지면 꺼졌다고 출력
		//시동이 꺼져있는 상태라면 시동이 꺼져있습니다. 시동을 켜주세요 라고 출력
		
		//speedUp/Down 기본조건은 power가 켜졌을 때만 가능
		//speedUp
		//300이상이면 최고 속도라고 출력
		//속도가 올라갈때마다 현재 속도 출력
		//speedDown : 속도가 0이되면 더이상 내려가지 않음. (멈췄습니다 속도가 0)
		//속도가 내려갈때마다 현재 속도 출력
		//속도가 0이 아닐때 시동을 끄려고 하면 시동을 끌수 없습니다 라고 뜨면서 현재 속도 출력
		// getter/setter
		Car2 c = new Car2(); 
		//Car2 클래스를 통해 c객체를 생성 
		//new 키워드를 통해 생성 Car2() 생성자에 의해 초기화 된다.
		c.setName("스파크");
		c.setColor("빨간색");
		c.setYear("2024");
		
		c.print();
		c.power();
		System.out.println("mycar power: "+(c.isPower()? "On":"Off"));
		
		
		
		
		
		c.speedUp();
		c.speedUp();
		c.speedUp();
		System.out.println("mycar speed:"+c.getSpeed());
		
		c.power();
		System.out.println("mycar power: "+(c.isPower()? "On":"Off"));
		
		
		
		c.speedDown();
		c.speedDown();
		c.speedDown();
		
		System.out.println("mycar speed:"+c.getSpeed());
		
		c.power();
		System.out.println("mycar power: "+(c.isPower()? "On":"Off"));
		
		
		Car2 c2 = new Car2("소나타", "2021");
		c2.print();
		
		Car2 c3 = new Car2();
	}

} 
class Car2{
	
	//클래스 명은 대문자 시작
	//멤버변수는 private으로 설정
	//메소드는 public으로 설정 => getter setter도 메소드
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	private int door;
	//power()
	//꺼져있을 때 -> 켜짐
	//켜져 있을 때 -> 꺼짐
	public void power() {
		if(!power && speed==0) {
			power=true;
			System.out.println("시동이 켜졌습니다.");
		}
		else if(power && speed ==0) {
			power=false;
			System.out.println("시동이 꺼졌습니다.");
		}
		else {
			System.out.println("속도가 높아서 시동 못끔 속도 줄이셈 현재속도: "+speed);
		}
	

	}
	

	public void speedUp() {
		if(!power) {
			System.out.println("시동이 꺼졌습니다. 시동 키세요");
			return;
		}
		if(speed>=300){
			System.out.println("최고 속력입니다. 현재 속도: "+speed);
		}
		else {
            speed += 10;
            System.out.println("현재 속도: " + speed);
        }
		
	}
	
	public void speedDown() {
		if(!power) {
			System.out.println("시동이 꺼져있음. 시동 키셈");
			return;
		}
		else if(speed<=0){
			speed=0;
			System.out.println("멈췄습니다 속도는: "+speed);
	}
		else {
			speed-=10;
			System.out.println("현재 속도: " + speed);
		}
	}
	public Car2() {
		//기본생성자
	}
	public Car2(String name, String year, String color, int door) {
		this(name,year);
		this.color = color;
		this.door = door;
	}
	public Car2(String name, String year) {
		this.name = name;
		this.year = year;
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
	public  int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door=door;
	}
	
}