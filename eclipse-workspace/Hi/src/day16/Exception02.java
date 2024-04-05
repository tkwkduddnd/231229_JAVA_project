package day16;

public class Exception02 {

   public static void main(String[] args) {
      try {
         System.out.println(1);
         System.out.println(2);
         System.out.println(div(1, 0)); //exception 발생 구문
         System.out.println(3);
         System.out.println(4);
      }
      catch(ArithmeticException e){
    	  System.out.println(e.getMessage());// 발생할 예외를 처리할 객체 e
         e.printStackTrace(); // 실제 예외 구문을 콘솔에 출력해줌
         System.out.println("예외가 발생");
      }
      
      //Exception이 발생돼도 처리됨
      System.out.println(5);
      System.out.println(6);
      
      
      
   }

  
   public static int div(int num1, int num2) throws RuntimeException{
      return num1 / num2;
   }
   //연산자가 / % 인 경우 num2가 0이면 예외 발생시키기
   
   //예외 발생시키기 : throw new 를 발생시킬 수 있음
   //throw : 예외 떠넘기기
   //예외를 발생시키게 되면 메소드 선언부 끝 부분에 throws를 적고
   //발생할 수 있는 예외를 반드시 적어줘야함
   //throws 는 RuntimeException만 예외적으로 생략 가능
   
   //기능: 두 수를 입력받고, 연산자를 입력받아 4칙연산의 결과를 리턴하는 메소드
   //매개변수: int num1, int num2, char op
   public static class Gyesan{
      private int num1;
      private int num2;
      private char op;
   
      
      public void calc() {
    	  if(op == '%' || op =='/') {
         	 throw new RuntimeException("num2는 0이 될 수 없습니다.");
          }
         switch (op) {
            case '+':
               System.out.println(num1 +"+" +num2+"="+(num1+num2));
               break;
            case '-':
               System.out.println(num1 +"%" +num2+"="+(num1-num2));
               break;
            case '*':
               System.out.println(num1 +"*" +num2+"="+(num1*num2));
               break;
            case '%':
            	System.out.println(num1 + "%"+ num2+"="+(num1%num2));
            	break;
            case '/':
               try {
                  System.out.println(num1 +"/" +num2+"="+(num1/num2));
               } catch (ArithmeticException e) {
            	   System.out.println(e.getMessage());
                  e.printStackTrace();
                  System.out.println("0으로 나눌 수 없습니다.");
               }
               break;
            default:
               throw new RuntimeException(op+"는 산술연산자가 아닙니다.");
         }
         
      }
   }
}