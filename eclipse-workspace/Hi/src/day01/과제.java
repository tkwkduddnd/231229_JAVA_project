package day01;

public class 과제 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      int kor = 75;
      int eng = 85;
      int math = 65;
      
      int sum = kor + eng + math;
      System.out.println("합계 :" +sum);
      
      double avg = sum/(double)3;
      System.out.println("평균 :" + avg);
      
      System.out.println(avg >= 80 ? "합격" : "불합격");
   }
}
