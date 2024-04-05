package Example;

public class For07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6의 약수 : 6%1 = 0, 6%2 = 0, 6%3 = 0, 6%4 = 2, 6%5 = 1, 6%6=0
		//6의 약수 : 1 2 3 6
		//12의 약수 : 1 2 3 4 6 12
		
		// 두 수의 공약수 : 1 2 3 6(두 수의 공통된 약수)
		
		//그 공약수 중 가장 큰 값 : 6
		
		int num1=6;
		int num2=12;
		
		int gcd = 0;
		for(int i=1;i<=num1;i++) {
			if(num1%i==0 && num2%i==0) {
				gcd = i;
			}
		}
		System.out.println(gcd);
		
		
		
		
		//break;
		//반복문에서 조건이 맞다면 반복문을 빠져나오는 역할
		for(int i=num1; ;i--) {
			if(num1 % i ==0 && num2 % i ==0) {
				System.out.println(i);
				break;
			}
		}
	}

}
