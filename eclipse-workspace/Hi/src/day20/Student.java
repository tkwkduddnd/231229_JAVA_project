package day20;

public class Student {
	//name과 score만 가지는 클래스 생성
	
	private String name;
	private int score;
	//생성자, getter/setter, toString
	public Student() {}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	
}

