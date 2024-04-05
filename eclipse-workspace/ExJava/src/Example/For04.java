package Example;

public class For04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1부터 10까지의 짝수의 합과, 홀수의 합
		
		int num=0;
		int num1=0;
		for(int i=0;i<=10;i++) {
			if(i%2==0) {
				num+=i;
			}
			else {
				num1+=i;
			}
		}
		System.out.println("짝수의 합은: "+num);
		System.out.println("홀수의 합은: "+num1);
	}

}
