package new02;

import java.util.Calendar;

public class SingetonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singeton s = Singeton.getInstance(); // static 이기 때문에 클래스에서 직접 접근
		
		Singeton s1 = Singeton.getInstance();
		if(s == s1) { // 주소가 같은지 확인
			System.out.println("s==s1은 같은 객체");
		}
		else {
			System.out.println("s!=s1 다른 객체");
		}
		
		Calendar c = Calendar.getInstance();
	}

}
