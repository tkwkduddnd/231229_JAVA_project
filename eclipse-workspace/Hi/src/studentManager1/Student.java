/*package studentManager1;

import java.util.Arrays;

public class Student {
	//학번, 이름, 나이, 전화번호, 주소, 수강과목
	//멤버변수, 생성자, getter/setter, toString
	//멤버변수에 학생이 듣고자하는 과목을 저장 Subject[]
	
	 * 메소드
	 * -학생정보 출력 메소드
	 * -수강과목 추가 메소드
	 * -수강과목 삭제 메소드
	 * -수강과목 출력 메소드
	 
	private String stdNum;
	private String stdName;
	private String stdPhone;
	
	private Subject [] subjectlist = new Subject[5];
	private int cnt;
	

		
		public Student(String stdNum, String stdName, String stdPhone) {
			this.stdNum = stdNum;
			this.stdName = stdName;
			this.stdPhone = stdPhone;
		}
	
	public void stdPrint() {
		System.out.println("--학생정보--");
		System.out.println("학생명: "+stdName+"과목번호: "+stdNum+"전화번호: "+stdPhone);
	}
	
	public void subPrint() {
		//subject 클래스의 toString 호출
		if(cnt==0) {
			System.out.println("수강중인 과목 없음");
			return;
		}
		//toString은 객체의 내용이 문자로 리턴 sysout(객체) => toString 호출
		for(int i = 0;i<cnt;i++) {
			System.out.println(subjectlist[i]); //toString 호출
		}
	}
		
		//수강과목 추가 메소드
		//매개변수: 수강과목 객체 Subject  subjectlist 배열에 해당 객체 담기
		
		public void insertSubject(Subject sub) {
			//배열 다 차면 늘려줘야함
			//배열은 길이 늘리기가 불가
			//배열 늘려줄때는 더긴 길이의 배열 생성 배열 복사 후 배열 바꾸기
			if(cnt == subjectlist.length) {
				Subject [] temp = new Subject[subjectlist.length+5];
				System.arraycopy(subjectlist, 0, temp, 0,cnt);
				subjectlist=temp;
			}
			subjectlist[cnt] = sub;
		}
		
		
	
		public void deleteSubject(Subject subName) {
			int index = -1;
			if(subName == null) {
				return;
			}
			for(int i = 0; i<cnt;i++) {
				if(subjectlist[i].getSubName().equals(subName)) {
					index = i;
					break;
				}
			}
			if(index == -1) {
				System.out.println("찾는 값이 없음");
				return;
			}
			
			System.out.println("삭제할 과목: ");
			String sName = scan.next();
			studentlist[index].deleteSubject(sName);
			
			for(int i = index; i<cnt-1;i++) {
				subjectlist[i] = subjectlist[i+1];
			}
			subjectlist[cnt-1] = null;
			cnt--;
		}

	public String getStdNum() {
		return stdNum;
	}

	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public Subject[] getSubjectlist() {
		return subjectlist;
	}

	public void setSubjectlist(Subject[] subjectlist) {
		this.subjectlist = subjectlist;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", stdPhone=" + stdPhone + ", subjectlist="
				+ Arrays.toString(subjectlist) + ", cnt=" + cnt + "]";
	}
	
}
*/
