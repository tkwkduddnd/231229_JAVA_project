package day10;

public class Class03 {
    public static void main(String[] args) {
        Car1 c = new Car1();
        c.setName("아반떼");
        c.setColor("파랑");
        c.setYear("2018");
        c.setDoor(4); 

        c.print();
        c.power(); 
        System.out.println("mycar 시동: "+(c.isPower()? "On":"Off"));
        c.speedUp();
        c.speedUp();
        c.speedUp();
        c.speedUp();
        c.speedUp();
        c.speedUp();
        c.speedUp();
        System.out.println("mycar 속도:"+c.getSpeed());
        c.power();
        System.out.println("mycar 시동: "+(c.isPower()? "On":"Off"));
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.speedDown();
        c.power();
        System.out.println("mycar 시동: "+(c.isPower()? "On":"Off"));
    }
}

class Car1 {
    private String name;
    private String color;
    private String year;
    private boolean power;
    private int speed;
    private int door;

    public void power() {
        if (!power && speed == 0) {
            power = true;
            System.out.println("시동이 켜졌습니다.");
        } else if (power && speed == 0) {
            power = false;
            System.out.println("시동이 꺼졌습니다.");
        } else {
            System.out.println("속도가 높습니다. 시동 끌거면 속도 줄이세요. 현재 속도: " + speed);
        }
    }

    public void speedUp() {
        if (!power) {
            System.out.println("시동이 꺼졌음. 시동을 켜주세요.");
            return;
        }

        if (speed >= 300) {
            System.out.println("현재 최고 속도입니다.");
        } else {
            speed += 10;
            System.out.println("현재 속도: " + speed);
        }
    }

    public void speedDown() {
        if (!power) {
            System.out.println("시동이 꺼져있습니다. 시동을 켜주세요.");
            return;
        }

        if (speed <= 0) {
            speed = 0;
            System.out.println("멈췄습니다. 속도가 0");
        } else {
            speed -= 10;
            System.out.println("현재 속도: " + speed);
        }
    }

    public void print() {
        System.out.println("mycar: "+name+"/"+color+"("+year+")"+"차 문 개수: "+door+"개");
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
	

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }
}