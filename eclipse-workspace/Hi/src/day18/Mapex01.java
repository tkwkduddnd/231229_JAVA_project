package day18;

import java.util.HashMap;

public class Mapex01 {

   public static void main(String[] args) {
      HashMap<String, Integer> map = new HashMap<>();
      Mapex01 m = new Mapex01();
      
      m.makeMap(map);
      int sum = m.calSum(map);
      m.printMapAndSum(map, sum);
      
      HashMap<String, Integer> map1 = m.makeMap2();
      int sum1 = m.calSum(map1);
      m.printMapAndSum(map1, sum1);
   }
   
   public void makeMap(HashMap<String, Integer> map){
      map.put("가위", 2500);
      map.put("크레파스", 4000);
      map.put("물감", 5000);
   }
   
   public HashMap<String, Integer> makeMap2(){
      HashMap<String, Integer> map = new HashMap<>();
      map.put("가위", 2500);
      map.put("크레파스", 4000);
      map.put("물감", 5000);
      
      return map;
   }
   
   public int calSum(HashMap<String, Integer> map){
      int sum = 0;
      for(Integer value : map.values()) {
         sum+= value;
      }
      return sum;
   }
   
   //map을 받아서 출력하고 합계를 출력하는 메소드
   public void printMapAndSum(HashMap<String, Integer> map, int sum){
      for(String key : map.keySet()) {
         System.out.println(key + ":" + map.get(key));
      }
      System.out.println("총합: "+ sum);
   }
}