package exexexex;

public class Test {

	public static void main(String[] args) {
		/*
		 * 변수 a 에 저장된 값들의 합을 출력
		 * ex) 배열의 합: 475
		 */
		
		
		int [][] a = {{10,20,50},{20,30,15},{100,110,120}};
		int sum = 0;
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				sum+=a[i][j];
				
			}
		}
		System.out.println("배열의 합: "+sum);

	}

}
