package day11;

public class Method09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 가변인자 메소드
		 * 매개변수 개수가 고정되지 않은 경우 사용
		 */
		Method09 m9 = new Method09();
		System.out.println(m9.sum(1,2,3,4,5));
		System.out.println(m9.sum(1,2,3,4,5,6,7,8,9,10));
	}
	public int sum(int...num) { //num을 배열처럼 처리
		int result = 0;
		for(int tmp:num) {
			result+=tmp;
		}
		return result;
	}

}

/*메소드를 이용해서 작업
 * 두 정수의 값이 주어졌을 때 
 * 두 정수 사이의 모든 정수의 합을 리턴하는 메소드
 * ex) a= 3, b= 5 => 3+4+5
 * ex) a=5, b=1 => 1+2+3+4+5
 * ex) a=3, b=3 => 3
 */
