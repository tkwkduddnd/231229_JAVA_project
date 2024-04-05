package EzenExample;

public class ex5 {

	public static void main(String[] args) {
		// Tv 객체 t를 생성합니다.
		Tv t = new Tv();
		// Tv의 전원을 켭니다.
		t.power();
		// Tv의 채널을 31번 올립니다. 채널은 0부터 19까지 있고, 19를 넘어가면 0으로 돌아갑니다.
		for (int i = 0; i < 31; i++) {
			t.chUp();
		}
		// Tv의 볼륨을 30번 올립니다. 볼륨은 0부터 10까지 있고, 10을 넘어가면 다시 10으로 설정됩니다.
		for (int i = 0; i < 30; i++) {
			t.volUp();
		}
	}

}

class Tv {
	// TV의 브랜드를 상수로 선언하고 초기화합니다.
	private final String BRAND = "LG";
	// TV의 전원 상태를 저장하는 변수를 선언합니다.
	private boolean power;
	// TV의 채널을 저장하는 변수를 선언합니다.
	private int ch;
	// TV의 볼륨을 저장하는 변수를 선언합니다.
	private int vol;

	// Tv 클래스의 생성자를 선언합니다. 볼륨을 3으로 초기화합니다.
	public Tv() {
		this.vol = 3;
	}

	// TV의 정보를 출력하는 메소드를 선언합니다.
	public void print() {
		System.out.println(BRAND + "의 Tv, ch: " + ch + ", vol: " + vol);
	}

	// TV의 전원을 제어하는 메소드를 선언합니다.
	public void power() {
		// power 변수의 값을 반전합니다.
		power = !power;
		// power가 true인 경우, TV가 켜졌음을 알리고 TV의 정보를 출력합니다.
		if (power) {
			System.out.println("전원이 켜집니다.");
			print();
		}
		// power가 false인 경우, TV가 꺼졌음을 알립니다.
		else {
			System.out.println("전원이 꺼집니다.");
		}
	}

	// TV의 채널을 올리는 메소드를 선언합니다.
	public void chUp() {
		// power가 true인 경우에만 채널을 올립니다.
		if (power) {
			ch++;
			System.out.println("ch: " + ch);
			// 채널이 20 이상이면 다시 -1로 설정하여 다음 호출 시 0이 되게 합니다.
			if (ch >= 20) {
				ch = -1;
			}
		}
		// power가 false인 경우, TV를 켜야한다는 메시지를 출력합니다.
		else {
			System.out.println("Tv를 켜주세요");
		}
	}

	// TV의 채널을 내리는 메소드를 선언합니다.
	public void chDown() {
		// power가 true인 경우에만 채널을 내립니다.
		if (power) {
			ch--;
			System.out.println("ch: " + ch);
			// 채널이 0 이하가 되면 다시 21로 설정하여 다음 호출 시 20이 되게 합니다.
			if (ch <= 0) {
				ch = 21;
			}
		}
		// power가 false인 경우, TV를 켜야한다는 메시지를 출력합니다.
		else {
			System.out.println("Tv를 켜주세요");
		}
	}

	// TV의 볼륨을 올리는 메소드를 선언합니다.
	public void volUp() {
		// power가 true인 경우에만 볼륨을 올립니다.
		if (power) {
			vol++;
			System.out.println("vol: " + vol);
			// 볼륨이 10 이상이면 다시 9로 설정하여 다음 호출 시 10이 되게 합니다.
			if (vol >= 10) {
				vol = 9;
			}
		}
		// power가 false인 경우, 전원을 켜야한다는 메시지를 출력합니다.
		else {
			System.out.println("전원을 켜주세요");
		}
	}

	// TV의 볼륨을 내리는 메소드를 선언합니다.
	public void volDown() {
		// power가 true인 경우에만 볼륨을 내립니다.
		if (power) {
			vol--;
			// 볼륨이 0 이하가 되면 음소거 상태임을 알리고 볼륨을 0으로 설정합니다.
			if (vol < 0) {
				vol = 0;
				System.out.println("음소거");
			} else {
				System.out.println("vol: " + vol);
			}
		}
		// power가 false인 경우, 전원을 켜야한다는 메시지를 출력합니다.
		else {
			System.out.println("전원을 켜주세요");
		}
	}

	// power의 getter 메소드입니다.
	public boolean isPower() {
		return power;
	}

	// power의 setter 메소드입니다.
	public void setPower(boolean power) {
		this.power = power;
	}

	// ch의 getter 메소드입니다.
	public int getCh() {
		return ch;
	}

	// ch의 setter 메소드입니다.
	public void setCh(int ch) {
		this.ch = ch;
	}

	// vol의 getter 메소드입니다.
	public int getVol() {
		return vol;
	}

	// vol의 setter 메소드입니다.
	public void setVol(int vol) {
		this.vol = vol;
	}

	// BRAND의 getter 메소드입니다.
	public String getBRAND() {
		return BRAND;
	}
}
