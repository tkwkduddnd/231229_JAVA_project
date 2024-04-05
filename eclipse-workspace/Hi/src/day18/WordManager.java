package day18;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordManager {
	
   HashMap<String, String> word = new HashMap<>();
   
   int count=0;
   public void insertWord(Scanner scan) {
      System.out.println("단어를 입력해주세요. ");
      System.out.println("단어: ");
      String voca = scan.next();
      System.out.println("의미: ");
      String mean = scan.next();
      
      word.put(voca, mean);
   }

   public void searchWord(Scanner scan) {
      System.out.println("검색할 단어 입력: ");
      String voca = scan.next();
      if(word.containsKey(voca)) {
         System.out.println(voca + ": " + word.get(voca));
      } 
   }

   public void correctWord(Scanner scan) {
	   //map은 set이 없음
	   // key 중복 불가능 => put => 덮어쓰기
      System.out.println("수정할 단어 입력: ");
      String voca = scan.next();
      if(word.containsKey(voca)) {
         System.out.println("수정할 의미 입력: ");
         String newMean = scan.next();
         word.put(voca, newMean);
         System.out.println("단어가 수정되었습니다.");
      } 
   }

   public void deleteWord(Scanner scan) {
      System.out.println("삭제할 단어 입력: ");
      String voca = scan.next();
      if(word.get(voca)!=null?true:false) {
         word.remove(voca);
         System.out.println("단어가 삭제되었습니다.");
      }
      else {
    	  System.out.println("선택한 단어가 없습니다.");
      }
   }

   public void printWord(Scanner scan) {
      for(String key : word.keySet()) {
    	  count++;
            System.out.println(count+key + ": " + word.get(key));
        }
   }
   

	public void printfile(Scanner scan) {
		// TODO Auto-generated method stub
		try {
	         FileWriter writer = new FileWriter("words.txt");
	         
	         for(String key : word.keySet()) {
	            writer.write(key + ": " + word.get(key) + "\r\n");
	         }
	         
	         writer.close();
	         System.out.println("파일이 저장되었습니다.");
	      } catch(IOException e) {
	         System.out.println("파일이 저장에 실패했습니다.");
	      }
	}
}
   

