package day12;

public class 과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student[] student = new Student[5];
		
		student[0] = new Student("홍길동", "000001", "010-0000-1234", "25");
		System.out.println(student[0]);
		
		student[1] = new Student("홍길동1", "000010", "010-1234-2345", "26");
		System.out.println(student[1]);
		
		student[2] = new Student("홍길동2", "000100", "010-2345-3456", "27");
		System.out.println(student[2]);
		
		student[3] = new Student("홍길동3", "001000", "010-3456-4567", "28");
		System.out.println(student[3]);
		
		student[4] = new Student("홍길동4", "001001", "010-4567-5678", "29");
		System.out.println(student[4]);
		
		
		Student[] studyGroupArr = new Student[5];
		
		studyGroupArr[0] = new Student("자바");
		System.out.println(studyGroupArr[0]);
		
		studyGroupArr[1] = new Student("파이썬");
		System.out.println(studyGroupArr[1]);
		
		studyGroupArr[2] = new Student("C");
		System.out.println(studyGroupArr[2]);
		
		studyGroupArr[3] = new Student("c++");
		System.out.println(studyGroupArr[3]);
		
		studyGroupArr[4] = new Student("html");
		System.out.println(studyGroupArr[4]);
	}

}


class Student{
	private String name;
	private String birth;
	private String pN;
	private int age;
	private final static String SCHOOLAFTER = "Ezen";
	private String center;
	private String studyGroup;
	private String year;
	
	
	
	
	
	@Override
	   public String toString() {
	      return studyGroup+":"+ year;
	   }
	
	public Student(String studyGruop) {
		this.studyGroup = studyGruop;
	}
	

	public Student(String name, String birth, String pN, String age) {
		return;
	}

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
	public String getpN() {
		return pN;
	}
	public void setpN(String pN) {
		this.pN = pN;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getStudyGroup() {
		return studyGroup;
	}
	public void setStudyGroup(String studyGroup) {
		this.studyGroup = studyGroup;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public static String getSchoolafter() {
		return SCHOOLAFTER;
	}
	
	
}


