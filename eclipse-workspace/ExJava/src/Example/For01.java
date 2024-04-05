package Example;

public class For01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for, while 동작방식이 같음
		 * => 조건에 맞지 않으면 한번도 실행되지 않을 수 있음
		 * do-while =>조건에 맞지 않아도 무조건 1번은 실행
		 * 
		 * 
		 */
		
		//1부터 10까지 출력
		for(int i = 1; i<=10;i++) {
			System.out.print(i+" ");
		}
		//i의 범위를 넘어가서 에러
		//System.out.println(i);
		System.out.println();
		System.out.println();
		
		//10부터 1까지 출력하는 예제
		for(int i=10;i>=1;i--) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println();
		
		//2부터 10까지의 짝수만 출력
		for(int i=2; i<=10;i+=2) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		System.out.println();
		
		for(int i=1; i<=5;i++) {
			System.out.print((i*2)+" ");
		}
		
		System.out.println();
		System.out.println();
		
		//1부터 10까지의 합계 출력
		
		int sum =0;
		for(int i=1;i<=10;i++) {
			sum +=i;
			
		}
		System.out.println(sum);
		
		
		
		
	}

}
