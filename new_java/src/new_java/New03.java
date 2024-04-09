package new_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class New03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 컬렉션 프레임워크
		 * List : 순서를 보장, 중복 저장 가능
		 * Set : 순서보장 x , 중복 x
		 * Map : 순서보장 x, 데이터를 쌍으로 저장
		 * Key(중복불가능), value(중복가능)
		 */
		
		// 리스트를 생성하고 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println();
		
		
		for(Integer tmp : list) {
			System.out.print(tmp+" ");
		}
		
		// map을 이용하여 이름 : 점수 형태로 3명만 출력
		HashMap<String, Integer> map = new HashMap<>();
		map.put("kim", 90);
		map.put("lee", 90);
		map.put("hong", 90);
		System.out.println(map);
		
		// key, value 형태로 map 출력하기
		
		 for (Entry<String, Integer> entrySet : map.entrySet()) {           
			 System.out.println(entrySet.getKey() + " : " + entrySet.getValue());        
			 }
		 Iterator<String> id = map.keySet().iterator();
		 while(id.hasNext()) {
			 String key = id.Next();
			 System.out.println(key+":"+map.get(key));
		 }

	}

}
