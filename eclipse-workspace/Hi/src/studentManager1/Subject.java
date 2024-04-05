package studentManager1;
/*
 * 하나의 수강과목 정보를 저장하는 클래스
 * 과목명, 학점, 시수, 교수명, 학기, 시간표, 강의장
 * 멤버변수, 생성자, getter/setter, toString
 */
public class Subject {
	private String subName;
	private int subTime;
	private String subprofessor;
	private String subScheduler;

	
	
		
	//생성자
	public Subject() {
		
	}
		//과목명
		public Subject(String subName) {
			this.subName = subName;
	}
		public String getSubName() {
			return subName;
		}
		public void setSubName(String subName) {
			this.subName = subName;
		}
		public int getSubTime() {
			return subTime;
		}
		public void setSubTime(int subTime) {
			this.subTime = subTime;
		}
		public String getSubprofessor() {
			return subprofessor;
		}
		public void setSubprofessor(String subprofessor) {
			this.subprofessor = subprofessor;
		}
		public String getSubScheduler() {
			return subScheduler;
		}
		public void setSubScheduler(String subScheduler) {
			this.subScheduler = subScheduler;
		}
		@Override
		public String toString() {
			return "Subject [과목명=" + subName + ", 시수=" + subTime + ", 교수 이름=" + subprofessor
					+ ", 시간표=" + subScheduler + "]";
		}
		
}

