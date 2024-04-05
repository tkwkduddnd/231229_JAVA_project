package Ex;

public class 문자열비교 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="Java";
		String s2 = "Python";
		
		System.out.println(s1.equals("Java"));
		System.out.println(s2.equals("Python"));
		//대소문자 구분하지 않고 비교 같으면 true, 틀리면 false
		System.out.println(s2.equalsIgnoreCase("python"));
		
		//문자열 비교 심화
		s1 ="1234";
		s2 ="1234";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		
		s1 = new String("1234");
		s2 = new String("1234");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		
		/*s1 ="1234";
		*s2 ="1234";
		* 이렇게 있으면 화장실 비밀번호를 벽에 붙여놓은 것처럼 해놓은 것이고
		* 
		* s1 = new String("1234");
		* s2 = new String("1234");
		* 이렇게 정의를 하면 각 테이블마다 화장실 비밀번호를 가져다 준 것처럼 해놓은 것이다
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
