package day12;

public class 과제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student3 student = new Student3();
		student.setName("홍길동");
		student.setPhone("010-1234-5678");
		student.setAge(25);
		student.printStuent();
		student.printAcademy();
		
		Student3 st1 = new Student3("Na", "010-1234-1234", "인천");
		st1.printStuent();
		st1.printAcademy();
		
		Student3 st2 = new Student3("Na1","000101","010-4567-8902",25, "대전");
		st2.printStuent();
		st2.printAcademy();

	}

}

class Student3{
	private String name;
	   private String birth;
	   private String phone;
	   private int age;
	   public final static String ACADEMY = "Ezen";
	   private String location;
	   private String[] Guamok = new String[5];
	   private int[] month = new int[5];
	   private int GuamokCount = 0;
	   
	   
	   //생성자
	   public Student3() {
		   
	   }
	   
	   public Student3(String name, String phone, String location) {
		   this.name = name;
		   this.phone = phone;
		   this.location = location;
	   }
	   public Student3(String name, String birth, String phone,int age, String location) {
		   this(name,phone,location); //생성자 호출은 항상 첫번째 줄에 생성
		   this.birth = birth;
		   this.age = age;
	   }
	 //메소드
	   public void printStuent() {
		   System.out.println("학생정보: ");
		   System.out.println("이름: "+name+", 나이: "+age+", 생년월일: "+birth+", 전화번호: "+phone);
	   }
	   public void printAcademy() {
		   System.out.println("학원 이름: "+ACADEMY+" 학원 위치: "+location);
	   }
	   
	   //수강 정보 출력
	   
	   //수강 정보 등록
	   //insertCourse

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getGuamok() {
		return Guamok;
	}

	public void setGuamok(String[] guamok) {
		Guamok = guamok;
	}

	public int[] getMonth() {
		return month;
	}

	public void setMonth(int[] month) {
		this.month = month;
	}

	public int getGuamokCount() {
		return GuamokCount;
	}

	public void setGuamokCount(int guamokCount) {
		GuamokCount = guamokCount;
	}

	public static String getAcademy() {
		return ACADEMY;
	}
	   
	   
	   
}
