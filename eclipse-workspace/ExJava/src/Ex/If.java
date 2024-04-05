package Ex;

public class If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour = 10;
		
		/*if(hour<14) {
			System.out.println("아이스 아메리카노 +1");
			System.out.println("샷 추가");
		}
		System.out.println("커피 주문 완료");
		*/
		hour = 15;
		
		boolean coffee = false;
		
		if(hour<14 && !coffee) {
			System.out.println("아메리카노 + 1");
		}
		
		hour = 15;
		
		coffee = true;
		if(hour>=14 || coffee == true) {
			System.out.println("아이스 아메리카노(디카페인) +1");
		}
		System.out.println("커피 주문완료 #1");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
