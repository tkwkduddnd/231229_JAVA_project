package Std;

import java.util.HashMap;
import java.util.Objects;

//멤버변수 : 이름, 나이, 전화번호, map(과목, 점수), 합계, 평균
	//생성자, 메소드, getter/setter, 출력메소드
	//메소드 - 출력 메소드(학생정보, 과목점수(성적표), 합계, 평균)
	//메소드 - map (과목, 점수) 데이터를 추가 메소드
	//메소드 - map (과목, 점수) 데이터를 삭제 메소드

public class Student {
	// 멤버변수 : 이름, 나이, 전화번호, map(과목, 점수), 합계, 평균
	private String name;
	private int age;
	private String phone;
	private HashMap<String, Integer> subject = new HashMap<>();  // 과목명과 점수를 저장하는 HashMap
	private int sum;
	private double avg;
	
	// 기본 생성자
	public Student() {}

	// 이름만 받아오는 생성자. 나이는 기본값으로 15로 설정
	public Student(String name) {
		this.name = name;
		this.age = 15;
	}
	
	// 이름, 나이, 전화번호를 받아오는 생성자
	public Student(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	// 과목과 점수를 추가하는 메소드
	public void addSubject(String sub, int subScore) {
		subject.put(sub, subScore);
		System.out.println("점수 추가");
	}
	
	// 한 학생의 정보를 출력하는 메소드
	public void printOne() {
		System.out.println(name+"("+age+") / ");
		if(phone != null) {
			System.out.println(phone);
		}
		System.out.println();
		if(subject.size()<=0) {
			System.out.println("점수가 없습니다.");
			System.out.println("-------------------");
			return;
		}
		printSub();  // 성적표 출력
		calc();  // 합계와 평균 계산
		System.out.println("결과 : "+sum+"["+avg+"]");
		System.out.println("--------------------------");
	}
	
	// 성적표를 출력하는 메소드
	public void printSub() {
		System.out.println("------성적표------");
		for(String sub : subject.keySet()) {
			System.out.println(sub+":"+subject.get(sub));
		}
		System.out.println("------------------------");
	}
	
	// 합계와 평균을 계산하는 메소드
	public void calc() {
		this.sum=0;
		this.avg=0;
		for(String sub : subject.keySet()) {
			sum += subject.get(sub);
		}
		avg = (double)sum/subject.size();
	}
	
	// 과목을 삭제하는 메소드
	public void delSub(String sub) {
		if(subject.remove(sub) == null) {
			System.out.println("해당과목이 없습니다.");
			return;
		}
		subject.remove(sub);
		System.out.println("점수 삭제!");
	}

	// getter/setter 메소드들
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public HashMap<String, Integer> getSubject() {
		return subject;
	}

	public void setSubject(HashMap<String, Integer> subject) {
		this.subject = subject;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	// equals와 hashCode 메소드
	@Override
	public int hashCode() {
        return Objects.hash(name);
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name); // 이름이 같으면 동일한 객체로 취급
	}

	// toString 메소드
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", phone=" + phone + ", sum=" + sum + ", avg=" + avg + "]";
	}
}


