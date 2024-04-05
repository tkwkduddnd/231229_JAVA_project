package Ex;

public class 삼항연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//삼항연산자
		//결과 = (조건) ? (참의 경우 결과값) : (거짓의 경우 결과값)
		
		int x=3;
		int y=5;
		int max=(x>y)? x:y;
		System.out.println(max);
		
		int min = (x<y)? x:y;
		System.out.println(min);
		
		boolean b = (x==y)? true:false;
		System.out.println(b);
		
		String s = (x!=y)? "다름":"같음";
		System.out.println(s);
		
		//어린이 키에 따른 놀이기구 탑승 가능 여부
		//조건 키가  120cm 이상인 경우만 탑승 가능
		//삼항 연산자 이용
		int key =120;
		int key1 = 119;
		
		String max1 =(key1<key)? "탑승 불가능": "탑승 가능"; 
		System.out.println("탑승자의 키가 "+key1+"cm 이므로 "+max1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
