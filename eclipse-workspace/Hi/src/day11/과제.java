package day11;

import java.math.MathContext;

public class 과제 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	/*메소드를 이용해서 작업
    	 * 두 정수의 값이 주어졌을 때 
    	 * 두 정수 사이의 모든 정수의 합을 리턴하는 메소드
    	 * ex) a= 3, b= 5 => 3+4+5 => 12
    	 * ex) a=5, b=1 => 1+2+3+4+5 =>15
    	 * ex) a=3, b=3 => 3
    	 */
        과제 k = new 과제();  
        System.out.println(k.sum(3,5));
        System.out.println(k.sum(5, 1));  
        System.out.println(k.sum(3, 3));  
        
        System.out.println(k.sum2(3,5));
        System.out.println(k.sum2(5, 1));  
        System.out.println(k.sum2(3, 3));
    }
    //1. 들어가는 값: 매개변수, 나오는 값: 리턴타입
    // 매개변수 : int a, b / 리턴타입: 합 => int sum
    //

    public int sum(int a, int b) {
    	//a와 b 사이의 모든 값 합계
    	// a와b 사이 비교해서 무조건 작은수부터 시작
        int sum = 0;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        //a는 작은 값, b는 큰 값 
        for (int i = a; i <= b; i++) {
            sum += i;
            
        }
        return sum;
    }
    public int sum2(int a, int b) {
    	int sum =0;
    	int max = Math.max(a, b);
    	int min = Math.min(a, b);
    	
    	for(int i=min; i<=max; i++) {
    		sum+=i;
    		
    	}
    	return sum;
    }
}


