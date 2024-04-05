package Ex;

public class 문자열후반 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I Like Java and Python and C";
		
		//문자열 변환
		
		//and를 , 로 변환해줌
		System.out.println(s.replace("and","," ));
		
		//인덱스 기준 7부터 시작됨
		System.out.println(s.substring(7));
		
		//
		System.out.println(s.substring(s.indexOf("Java")));
		
		s="         I Love Java.        ";
		System.out.println(s);
		System.out.println(s.trim());//앞뒤 공백 제거
		
		//문자열 결합
		String s1 = "Java";
		String s2 = "Python";
		System.out.println(s1+s2);
		System.out.println(s1.concat(",").concat(s2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
