package day18;

import java.util.HashMap;
import java.util.Scanner;

public class MapEx02 {

   public static void main(String[] args) {
      
      HashMap<String,String> voca = new HashMap<>();
      Scanner scan = new Scanner(System.in);
      
      System.out.println("--단어장--");
      
      for(int i = 0; i < 3; i++){
            System.out.println((i+1) + "번째 단어 입력: ");
            String eng = scan.nextLine();
            System.out.println(eng + "의 한글 뜻 입력: ");
            String kor = scan.nextLine();
            voca.put(eng, kor);
      }
      String eng = "가나다";
      System.out.println(voca.equals(eng));
      System.out.println("--입력된 단어장--");
      for(String key : voca.keySet()){
            System.out.println(key + " : " + voca.get(key));
      }
      
      scan.close();
   }
}