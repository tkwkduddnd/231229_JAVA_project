package day11;

public class Method10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 재귀 메소드: 메소드 안에서 본인 메소드 호출
		 * ! : 팩토리얼
		 * 0! = 1
		 * 1! = 1
		 * 2! = 1*2
		 * 3! = 1*2*3
		 */
		Method10 m10 = new Method10();
		System.out.println(m10.fact(5));
		System.out.println(m10.factorial(10));
	}
	public int fact(int num) {
		if(num<0) {
			return 0;
		}
		if(num==0 || num ==1) {
			return 1;
		}
		int res =1;
		for(int i=2; i<=num; i++) {
			res*=i;
		}
		return res;
	}
	
	//재귀 메소드
	public int factorial(int num) {
		if(num<0) {
			return 0;
		}
		if(num==0 || num ==1) {
			return 1;
		}
	
	return num * factorial(num-1);

}
}
