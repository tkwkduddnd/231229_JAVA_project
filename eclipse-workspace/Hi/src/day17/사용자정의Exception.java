package day17;

public class 사용자정의Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * password Exception
		 * 비밀번호는 null일 수 없다.
		 * 비밀번호의 길이는 5자 이상
		 * 비밀번호는 문자로만 이루어지면 안됨(문자+숫자+특수문자...)
		 * 
		 */
		
		PasswordTest pt = new PasswordTest();
		String passWord = "12123%";
		try {
			pt.setPassWord(passWord);
			System.out.println(pt.getPassWord());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class PasswordTest{
	private String passWord;

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		
		//Exception 처리
		if(passWord == null) {
			throw new PasswordException("비밀번호는 null일 수 없습니다.");
		}
		else if(passWord.length() <5){
			throw new PasswordException("비밀번호는 5자 이상이어야 합니다.");
			
		}
		else if(passWord.matches("[a-zA-Z]+"));
		throw new PasswordException("비밀번호는 숫자나 특수문자를 포함해야합니다.");
	}
	
	
}