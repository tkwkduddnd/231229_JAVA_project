package day11;

public class Method08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 메소드 오버로딩: 동일한 이름의 메소드를 여러개 만듬
		 * 오버로딩 조건
		 * 1. 매개변수의 개수 다르면 가능
		 * 2. 매개변수 타입(종류) 다르면 가능
		 * 리턴타입 상관없음, 매개변수 이름 상관없음
		 * 
		 */
		Method08 m8 = new Method08();
		int sum = m8.sum(10, 20);
		System.out.println(sum);
		System.out.println(m8.sum(10, 20, 30));
		System.out.println(m8.sum(1.1, 1.2));

	}
	//num1과 num2 합 리턴하는 메소드
	public int sum(int num1, int num2) {
		int hap = num1 + num2;
		return hap;
	}
	//메소드 오버로딩
	public int sum(int num1, int num2, int num3) {
		int hap = num1+num2+num3;
		return hap;
	}
	public double sum(double num1, double num2) {
		double hap = num1+num2;
		return hap;
	}

}
