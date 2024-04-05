/*package studentManager1;

import java.util.Scanner;

public class StudentManager implements Program{
	
	//학생 배열을 멤버변수로 추가
	private Student[] studentlist[] = new Student[5];
	//index 처리 변수
	private int stdcnt;
	



	@Override
	public void printStudent() {
		// TODO Auto-generated method stub
		System.out.println("전체 학생 정보");
		for(int i= 0; i<stdcnt;i++) {
			studentlist[i].stdPrint();
		}
	}
	@Override
	public void insertStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("학번: ");
		String stdNum = scan.next();
		System.out.println("학생명: ");
		String name = scan.next();
		System.out.println("전화번화:");
		String phone = scan.next();
		
		
		//입력받은 값을 객체로 생성(Student)
		Student s = new Student(stdNum, name, phone);
		//배열이 다 찼을 경우 배열복사
		if(stdcnt == studentlist.length) {
			Student[] temp = new Student[studentlist.length+5];
			System.arraycopy(studentlist, 0, temp, 0, stdcnt);
		}
		studentlist[stdcnt] =s;
		stdcnt++;
		
	}

	@Override
	public void searchStudent(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("검색할 학생명: ");
		String searchName = scan.next();
		
		for(int i=0;i<stdcnt;i++) {
			if(searchName.equals(studentlist[i].getstdName())) {
				studentlist[i].stdPrint();
				studentlist[i].stdPrint();
				return;
				
			}
		}
		System.out.println("검색한 이름이 없습니다.");
		
	}

	@Override
	public void registerSubject(Scanner scan) {
		/*
		 * 누가 무슨 과목을 추가할지 설정
		 * 수강신청할 학생이름을 입력받아
		 * 학생의 위치를 탐색 후
		 * 그 학생의 배열에 수강과목을 추가
		 * 수강과목의 객체를 생성해서 Student 클래스의 insertSubject 호출(해당 배열에 추가)
		 
		//누가 무슨 과목을 추가할지 설정
		//수강신청할 학생이름을 입력받아
		System.out.println("수강신청할 학생의 이름: ");
		String name = scan.next();
		int index = -1; //학생의 번지를 저장
		
		for(int i=0;i<stdcnt;i++) {
			if(name.equals(studentlist[i].getstdname())) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			System.out.println("학생 정보 없음");
			return;
		}
		System.out.println("수강신청 과목: ");
		String sName = scan.next();
		Subject s = new Subject(sName);
		studentlist[index].insertSubject(s);
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	}
*/