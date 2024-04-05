package day02;

import java.util.Scanner;

public class 과제 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      //정수 2개와 연산자 1개 입력받아 두 정수의 연산 출력
      //다른 종류의 연산자가 들어오면 잘못된 연산자로 출력
      
      Scanner scan = new Scanner(System.in);
      System.out.println("첫 번째 정수값을 입력하세요: ");
      int num = scan.nextInt();
      System.out.println("내가 입력한 수: "+num);
      
      System.out.println("두 번째 정수값을 입력하세요: ");
      int num1 = scan.nextInt();
      System.out.println("내가 입력한 수: "+num1);
      
      System.out.println("연산자를 입력하세요: ");
      String ch = scan.next();
      System.out.println("내가 입력한 연산자: "+ch);
      
      if(ch.equals("+")) {
         System.out.println(num + " " + ch + " " + num1 + " = " + (num + num1));
      } 
      else if(ch.equals("-")) {
         System.out.println(num + " " + ch + " " + num1 + " = " + (num - num1));
      } 
      else if(ch.equals("*")) {
         System.out.println(num + " " + ch + " " + num1 + " = " + (num * num1));
      } 
      else if(ch.equals("/")) {
         System.out.println(num + " " + ch + " " + num1 + " = " + ((double)num / num1));
         } 
       
      else if(ch.equals("%")) {
         System.out.println(num + " " + ch + " " + num1 + " = " + (num % num1));
      } 
      else {
         System.out.println("잘못된 연산자입니다.");
      }
      
      scan.close();
   }
}
