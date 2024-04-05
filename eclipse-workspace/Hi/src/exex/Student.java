package exex;

import java.util.HashMap;

public class Student {
	/*
	 * 멤버변수 : 이름, 나이, 전화번호, map(과목, 점수), 합계, 평균
	 * 생성자, 메소드, getter / setter, 출력메소드
	 * 메소드 : 출력메소드 (학생정보, 과목점수(성적표), 합계, 평균)
	 * 메소드 - map(과목, 점수) 데이터를 추가 메소드
	 * 메소드 - map(과목, 점수) 데이터를 삭제 메소드
	 * 
	 * 멤버변수 private 설정 / 메소드 public
	 * 클래스명은 대문자로 시작, 변수명, 메소드명은 소문자로 시작
	 */
	private String name;
	private String phone;
	private int age;
	private HashMap<String, Integer> subject = new HashMap<>();
	private int sum;
	private double avg;
	
	
	public Student() {
		
	}
	public Student(String name) {
		this.name = name;
		this.age = 15;
	}
	
	//출력 메소드 - 학생 1명의 정보출력
	public void printOne() {
		System.out.println(name+"/"+age);
		if(phone != null) {
			System.out.println(phone);
		}
		System.out.println();
		if(subject.size() <0) {
			System.out.println("점수가 없습니다.");
			return;
		}
		printSub();
		calc();
		System.out.println("결과: "+sum+"/"+avg);
	}
	//학생의 성적표 출력 - map 추렭
	public void printSub() {
		for(String sub : subject.keySet()) {
			System.out.println(sub+":"+subject.get(sub));
		}
	}
	//합계 평균 출력
	public void calc() {
		this.sum=0;
		this.avg=0;
		for(String sub : subject.keySet()) {
			sum += subject.get(sub);
		}
		avg = sum/(double)subject.size();
		
	}
	//과목 추가
	public void addSub(String sub, int score) {
		subject.put(sub, score);
		System.out.println("점수추가");
	}
	//과목 삭제
	public void delSub(String sub) {
		
		if(subject.remove(sub) == null) {
			System.out.println("해당과목 없음");
			return;
		}
		System.out.println("삭제 완료");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
