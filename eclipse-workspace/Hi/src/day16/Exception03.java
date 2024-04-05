package day16;

public class Exception03 {

	public static void main(String[] args) {
		/*
		 * 자주 발생하는 예외 코드들
		 * ArithmeticException : 0으로 나눴을 때 발생하는 Exception
		 * NullPointException : 객체의 값이 null일때 예외를 발생시킴
		 * ClassCastException : 다운 캐스팅이 잘못 됐을 때 (형변환 오류)
		 */
		int arr[] = new int[5];
		for(int i=0;i<=arr.length;i++) {
			System.out.println(arr[i]);
		}
		int arr2[] = null;
		System.out.println(arr2);

	}

}
