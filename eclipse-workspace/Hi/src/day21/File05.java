package day21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File05 {

   public static void main(String[] args) throws IOException{
      HashMap<String, Integer> map = new HashMap<>();
      BufferedReader br = new BufferedReader(new FileReader("test.txt"));

      String line;
      int sum = 0;
      while ((line = br.readLine()) != null) {
         String[] parts = line.split(" ");
         if (parts.length < 2) {
            continue;  
         }
         int score = Integer.parseInt(parts[1]);
         map.put(parts[0], score);
         sum += score;
      }

      for(String key : map.keySet()) {
         System.out.println(key + ":" + map.get(key));
      }
      System.out.println("총합: "+ sum);
      System.out.println("평균: "+ (double)sum / map.size());
      
      //br 끊기
      if(br != null) { //객체가 생성되었다면 끊기
    	  br.close(); 
      }
      
      
   }
}