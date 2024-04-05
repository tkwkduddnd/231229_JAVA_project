package Ex;

public class 퀴즈3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//주민등록번호에서 생년월일 및 성별까지만 출력하는 프로그램 작성
		//주민등록번호는 13자리의 숫자로 구성
		//앞 6자리는 생년월일 정보, 뒷 7자리는 첫 번째 숫자는 성별 정보
		//입력 데이터는 - 을 포함한 14자리의 문자열 형태
		
		String joomin = "990723-1183928";
		
		
		System.out.println(joomin.substring(0,8)); // 0 위치부터 8 위치 직전까지
		joomin = "990723-1183928";
		System.out.println(joomin.substring(0,joomin.indexOf("-")+2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
