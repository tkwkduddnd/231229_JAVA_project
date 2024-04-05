package exexexex;

import java.util.Scanner;

public class RandomNumber {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.println("난수의 개수를 입력하세요: ");
      int num = scan.nextInt();
      
      int sum  = 0;
      
      for(int i=1; i<=num; i++) {
         int random = (int)(Math.random() * 100) + 1;
         sum += random;
         System.out.println("생성된 난수: " +random);
      }
      System.out.println(num + "개의 난수의 합: "+sum);
   }

}