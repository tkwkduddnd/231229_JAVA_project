package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List01 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * 하루 일과를 저장하는 list 생성
		 * 출력은 for문/ 향상된 for문 / iterator
		 * import 단축키 컨트롤 + 쉬프트 + o
		 */
		
		List<String> list = new ArrayList<String>();
		
		list.add("잠자기");
		list.add("밥먹기");
		list.add("학원가기");
		list.add("밥먹기");
		list.add("자기");
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println("-------------------------------------");
		
		for(String s : list) {
			System.out.println(s);
		}
		
		
		System.out.println("-------------------------------------");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) { 
			String tmp = it.next(); 
			System.out.print(tmp+" ");
		}
		System.out.println();
		
		
		//정렬
		Collections.sort(list);
		System.out.println(list);
		
		//내림차순으로 정렬
		
		list.sort(new Comparator<String>(){
			//숫자는 (크다, 작다를 이용) -/+의 값이 출력
			//문자는 compareTo 메소드를 활용하여 정렬
			//s1.compareTo(s2) : 오름차순
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println(list);
	}

}
