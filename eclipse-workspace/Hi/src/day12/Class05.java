package day12;


/* 생성자 : 객체 생성할 때 값을 초기화 하는 방법
 * 기본값, 명시적 초기값, 초기화 블력, 생성자
 * 1. 기본값 : 기본적으로 지정되는 값
 * 2. 명시적 초기값 : 멤버변수를 선언함과 동시에 값을 지정
 * ex) private String name = "홍길동"; => 명시적 초기값
 * 3. 초기화 블럭 : {  } 멤버변수 초기화
 * 4. 생성자 : 객체를 생성할 때 초기화 해서 생성
 * 
 * 초기화의 우선순위
 * 기본값 => 명시적 초기값 => 초기화 블럭값 => 생성자
 * 
 */
public class Class05 {

   public static void main(String[] args) {
      EzenStudent[] studentArr = new EzenStudent[5]; 
      
      studentArr[0] = new EzenStudent("인천","순이", "자바", "111");
      System.out.println(studentArr[0]);
      
      studentArr[1] = new EzenStudent("인천","영이", "java", "222");
      System.out.println(studentArr[1]);
      
      studentArr[2] = new EzenStudent("인천","영2", "java", "222");
      System.out.println(studentArr[2]);
      
      studentArr[3] = new EzenStudent("인천","영2", "java", "333");
      System.out.println(studentArr[3]);
      
      studentArr[4] = new EzenStudent("인천","영3", "java", "444");
      System.out.println(studentArr[4]);
      
      
      System.out.println("------------------------------");
      //파이썬 듣고있는 학생 없으면 없다고 출력
      String subject = "python";
      int cnt=0;
      
      for(int i=0;i<studentArr.length; i++) {
         if(studentArr[i].getGroup().equals(subject)) {
            System.out.println(studentArr[i]);
            cnt++;
         }
      }
         if(cnt==0){
        	 System.out.println("파이썬 듣는 사람 없음");
         }
         
         
         }
      
   
   
      
   }



class EzenStudent {
   
   private String gigum;
   private  String student;
   private String group;
   private  String pN;
   
   public EzenStudent() {} 

   public EzenStudent(String gigum,String student, String group, String pN) {
      this.gigum = gigum;
      this.student = student;
      this.group = group;
      this.pN = pN;
   }
   
   {
      gigum = "인천";
      student ="미상";
      group = "미정";
      pN = "010";
   }
   
   @Override
   public String toString() {
      return gigum+" "+student +" " + "group=" + group+" "+ "pN=" + pN;
   }

   public String getStudent() {
      return student;
   }

   public void setStudent(String student) {
      this.student = student;
   }

   public String getGroup() {
      return group;
   }

   public void setGroup(String guamok) {
      this.group = group;
   }

   public String getpN() {
      return pN;
   }

   public void setpN(String pN) {
      this.pN = pN;
   }
}