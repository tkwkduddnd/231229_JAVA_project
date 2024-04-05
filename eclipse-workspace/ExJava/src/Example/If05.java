package Example;

public class If05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * switch문 : 값에 따라 케이스를 달리주는 형식
		 */
		int num = 10;
		
		switch(num%2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break;
			default:
				System.out.println("잘못된 값입니다.");
			
		}
		
		int num2 = 2;
		//num2의 값에 따라 1,2,3 인지 출력
		
		switch(num2) {
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		}
	}

}
