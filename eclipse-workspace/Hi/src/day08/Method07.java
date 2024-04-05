package day08;

import java.util.Random;

public class Method07 {
	
	// boolean 메소드 쓴 것

   public static void main(String[] args) {
      int lotto[] = new int[7];
      int user[] = new int[6];
      
      lotto(lotto);
      user(user);
      
      for (int i = 0; i < lotto.length; i++) {
         System.out.println("로또 번호: " + lotto[i]);
      }
      
      for (int i = 0; i < user.length; i++) {
         System.out.println("내 번호: " + user[i]);
      }
   }
   
   public static void lotto(int[] array) {
      Random random = new Random();
      for (int i = 0; i < array.length; i++) {
         int temp = random.nextInt(45) + 1;
         if (check(array, temp)) {
            i--;
         } else {
            array[i] = temp;
         }
      }
   }
   
   public static void user(int[] array) {
      Random random = new Random();
      for (int i = 0; i < array.length; i++) {
         int temp = random.nextInt(45) + 1;
         if (check(array, temp)) {
            i--;
         } else {
            array[i] = temp;
         }
      }
   }
   
   public static boolean check(int[] array, int value) {
      for (int i = 0; i < array.length; i++) {
         if (array[i] == value) {
            return true;
         }
      }
      return false;
   }
}