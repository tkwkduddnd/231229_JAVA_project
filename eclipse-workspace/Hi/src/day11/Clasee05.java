package day11;

public class Clasee05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tv1 tv = new tv1("LG");
		tv.power();

	}
	

}

class tv1 {
	private String brand;
	private boolean power;
	private int channel;
    private int volume;
	
	
	public tv1() {}
	public tv1(String brand) {
		this.brand = brand;
		this.volume = 3;
	}
	public void print() {
		System.out.println(brand+","+volume+","+channel);
		
	}
	public void power() {
		power = !power; 
		if(power) {
			System.out.println("전원 켜짐");
			print();
			
		}
		else {
			System.out.println("전원 꺼짐");
		}
	}
	
	public void channelUp() {
		if(power) {
			channel++;
			System.out.println("채널: "+channel);
			if(channel>=20) {
				channel=0;
			}
		}
		else {
			System.out.println("전원 켜세요");
		}
	}
}
