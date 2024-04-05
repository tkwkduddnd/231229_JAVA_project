package Std;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements Program{

	private ArrayList<Student> list = new ArrayList<>();  // 학생 정보를 저장할 ArrayList 선언

	public void add() {  // 미리 정의된 학생 정보 추가
		list.add(new Student("홍길동"));
		list.add(new Student("김영이"));
		list.add(new Student("김영이2"));
		list.add(new Student("김영이3"));
		list.add(new Student("김영이4"));
	}
	
	public void addStd(Scanner scan) {  // 사용자로부터 학생 정보를 입력받아 추가
		System.out.println("학생명: ");
		String name = scan.next();
		System.out.println("나이: ");
		int age = scan.nextInt();
		System.out.println("전화번호: ");
		String phone = scan.next();
		
		Student s = new Student(name, age, phone); // 입력받은 정보로 학생 객체 생성
		
		list.add(s);  // 생성된 학생 객체를 리스트에 추가
		System.out.println("학생추가 완료");
	}
	

	public void printStd() {  // 리스트에 저장된 모든 학생 정보 출력
		for(int i=0; i<list.size(); i++) {
			list.get(i).printOne();
		}
	}

	public void searchStd(Scanner scan) {  // 사용자로부터 이름을 입력받아 해당 학생 정보 검색 및 출력
		System.out.println("학생 이름: ");
		String name = scan.next();
		for(Student s : list) {
			if(s.getName().equals(name)) {
				s.printOne();
				return;
			}
		}
		System.out.println("검색된 학생이 없습니다.");
	}

	public void modStd(Scanner scan) {  // 사용자로부터 학생 이름을 입력받아 해당 학생 정보 수정
		System.out.println("학생명: ");
		String name = scan.next();
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {  // 입력받은 이름과 같은 학생이 있다면
				System.out.println("수정할 정보(이름,나이,전화번호중 택1)");
				String op = scan.next();
				System.out.println("수정할 값 입력");
				switch(op) {
				case "이름":  // 이름 수정
					String modName = scan.next();
					list.get(i).setName(modName);
					break;
				case "나이":  // 나이 수정
					int modAge = scan.nextInt();
					list.get(i).setAge(modAge);
					break;
				case "전화번호":  // 전화번호 수정
					String modPhone = scan.next();
					list.get(i).setPhone(modPhone);
					break;
					default:
						System.out.println("정보가 존재하지 않습니다.");
						break;
				}
				System.out.println("수정완료");
				return;
			}
		}
		System.out.println("학생이 존재하지 않습니다.");
	}

	public void delStd(Scanner scan) {  // 사용자로부터 학생 이름을 입력받아 해당 학생 정보 삭제
		System.out.println("학생이름: ");
		String name = scan.next();
		boolean result = list.remove(new Student(name));
		if(!result) {
			System.out.println("학생이 없습니다.");
			return;
		}
		System.out.println("학생 삭제 완료");
	}

	public void addSub(Scanner scan) {  // 사용자로부터 학생 이름과 과목, 점수를 입력받아 과목 점수 추가
			System.out.println("학생 이름: ");
			String name = scan.next();
			
			for(int i=0;i<list.size(); i++) {
				if(list.get(i).getName().equals(name)) {  // 입력받은 이름과 같은 학생이 있다면
					System.out.println("과목명: ");
					String sub = scan.next();
					System.out.println("점수: ");
					int subScore = scan.nextInt();
					list.get(i).addSubject(sub, subScore);  // 과목 점수 추가
					return;
				}
			}
			System.out.println("학생이 없습니다.");
	}

	public void modsub(Scanner scan) {  // 사용자로부터 학생 이름과 과목, 점수를 입력받아 과목 점수 수정
		System.out.println("학생 이름: ");
		String name = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {  // 입력받은 이름과 같은 학생이 있다면
				System.out.println("수정할 과목: ");
				String subName = scan.next();
				System.out.println("수정할 점수: ");
				int subScore = scan.nextInt();
				list.get(i).addSubject(subName, subScore);  // 과목 점수 수정
				return;
			}
		}
		System.out.println("학생이 없습니다.");
	}

	public void delSub(Scanner scan) {  // 사용자로부터 학생 이름과 과목을 입력받아 과목 점수 삭제
		System.out.println("학생 이름: ");
		String name = scan.next();
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {  // 입력받은 이름과 같은 학생이 있다면
				System.out.println("과목: ");
				String sub = scan.next();
				list.get(i).delSub(sub);  // 과목 점수 삭제
				return;
			}
		}
		System.out.println("학생이 없습니다.");
	}
}
