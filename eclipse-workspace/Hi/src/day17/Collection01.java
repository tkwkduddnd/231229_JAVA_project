package day17;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Collection01 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 *  컬렉션 프레임워크 : 표준화된 방식의 자료구조
		 *  List , Set , Map => 인터페이스 . 반드시 구현 클래스로 객체를 생성
		 *  데이터를 묶어서 관리할 때 사용
		 *  주로 배열대신 사용
		 *  
		 *  List(배열과 동일)
		 *  -값을 하나씩 저장
		 *  -순서를 보장(index)
		 *  -중복 허용
		 *  -배열 대신에 가장 많이 사용하는 구조
		 *  
		 *  Set
		 *  -값을 하나씩 저장
		 *  -순서를 보장하지 않음 (index가 없음)
		 *  -중복을 허용하지 않음 (동일한 값이 입력되면 버려짐)
		 *  
		 *  Map
		 *  - 값을 두개씩 저장 key / value 쌍으로 저장
		 *  - key는 중복 불가 / value는 중복 가능
		 *  -key가 중복되면 value는 덮어쓰게 됨
		 *  - 아이디 / 패스워드와 같이 하나의 자료를 묶어서 사용
		 *  
		 *  배열은 기본자료형, 클래스 자료형으로 구성 가능
		 *  int arr[] String arr[] Student arr[] 전부 가능
		 *  Collection에서는 기본 자료형 불가능. 클래스 자료형만 구성가능
		 *  기본 자료형에 맞는 클래스 자료형을 사용하면됨.
		 *  
		 *  int => Integer,String
		 *  나머지는 기본 자료형에 첫글자만 대문자로 변환하면 클래스가 됨
		 *  
		 *  ex) long => Long, byte=> Byte, boolean => Boolean
		 *  만약 클래스를 지정하지 않으면 Object가 자동 설정됨
		 *  
		 *  List<클래스명> 객체명 = new 구현 클래스<클래스명>();
		 *  List => 구현 클래스 : ArrayList, LinkedList
		 *  
		 *  ArrayList : 검색 시 유리
		 *  - 미리 길이를 지정하지 않음. 추가되면 늘어남. 삭제되면 줄어듬
		 *  - 추가, 삭제가 쉽다. 검색이 쉬움
		 *  
		 *  LinkedList : 추가, 삭제가 많을 경우 유리
		 *  -값을 중간에 끼워넣거나, 빼는게 쉬움
		 *  -검색이 느리다.
		 *  
		 */
		List<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList list2 = new ArrayList();
		ArrayList<Integer> list3 = new ArrayList<>();
		
		//add() : 요소를 추가
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		
		//get(index) : 인덱스 번지의 요소를 가져옴
		System.out.println(list.get(0));
		
		System.out.println("------------------------");
		//set(index, 값) : 인덱스 번지의 값을 변경하기
		list.set(0, 5);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list);
		
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------------------");
		//size() : 총 개수 확인
		System.out.println(list.size());
		
		//문자열을 담을 수 있을 ArrayList를 생성
		//문자열 5개를 저장한 후 출력
		//총 개수가 몇개인지도 출력
		System.out.println("----------------------------------------------");
		
		
		List<String> list4 = new ArrayList<String>();
		list4.add("사과");
		list4.add("배");
		list4.add("바나나");
		list4.add("과자");
		list4.add("딸기");
		
		for(int i=0; i<list4.size();i++) {
			System.out.println(list4.get(i));
		}
		System.out.println(list4.size()+"개");
		System.out.println("--------------------------");
		//향상된 for문
		for(String s : list4) {
			System.out.println(s);
		}
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		//list1에 1부터 10까지 값을 지정 한 후 출력
		
		for(int i = 0; i<10; i++) {
			
			
			list1.add(i+1);
			
		}
		System.out.println(list1);
		
		//set(index, 값) 0번지 값을 7로 변경
		list1.set(0, 7);
		System.out.println(list1);
		
		//remove(index) : index 번지의 값을 삭제
		//remove(object) : object 의 요소를 삭제
		list1.remove(0);
		System.out.println(list1);
		
		Integer a = 9;
		list1.remove(a);
		System.out.println(list1);
		
		
		//contains(object) : list에 값이 있는지 검사 true / false로 리턴
		
		System.out.println(list1.contains(a));
		
		//clear() : 리스트를 비움(요소 전부를 삭제)
		list1.clear();
		System.out.println(list1);
		
		//isEmpty() : 리스트가 비어있는지 체크 비어있으면 true / false
		System.out.println(list1.isEmpty());
		
		//ArrayList로 number를 생성 숫자를 저장하는 리스트
		//1부터 10까지 채운 후 출력
		
		
		for(int i=0; i<10; i++) {
			list1.add(i+1);
		}
		
		
		for(Integer s1 : list1) {
			System.out.println(s1);
		}
		System.out.println("--------------------------");
		
		
		//Iterator : index가 없는 값을 출력하기 위해 사용
		//list에서는 순서를 보장하기 때문에 get(i)를 사용하여 원하는 번지에 접근가능
		//set / map은 순서를 보장하지 않기 때문에 일반 for문을 사용할 수 없음
		//향상된 for문이나 Iterator를 사용
		// 순서와 상관없이  값을 가져올 수 있는 구문을 사용해야함
		// map은 향상된 for문, Iterator 둘다 직접 사용 불가능
		
		System.out.println(" >> Iterator 출력");
		
		Iterator<Integer> it = list1.iterator();
		while(it.hasNext()) { //hasnext() 다음 요소가 있는지 체크 true / false
			Integer tmp = it.next(); // next()는 다음요소 가져오기
			System.out.print(tmp+" ");
		}
		System.out.println();
		
		//indexOf(값) : 해당 값이 list에 있는지 확인하고 그 index를 반환 / 없다면 -1 리턴
		System.out.println(list1.indexOf(a));
		System.out.println(list1.contains(a));
		
		//list1 리스트를 비우고, 값을 무작위로 5개만 추가
		list1.clear();
		list1.add(4);
		list1.add(2);
		list1.add(9);
		list1.add(1);
		list1.add(19);
		System.out.println(list1);
		
		//정렬
		//Collections.sort() // 오름차순으로 정렬 / 오름차순만 가능
		Collections.sort(list1);
		System.out.println(list1);
		
		
		
		// sort(Comparator를 구현한 객체) : 정렬
		// Comparator 인터페이스를 구현한 구현체를 넣어야 함. (익명 클래스 사용)
		// compareTo 메소드를 구현하여 객체를 정렬
		// - compareTo : 사전상으로 앞에 있으면 -1, 같으면 0, 뒤에 있으면 1
		
		list1.sort(new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				//o1 - o2 : 오름차순 /o2 - o1 : 내림차순 정렬
				//결과가 마이너스이면 앞으로 보내고 +면 뒤로 보내는 역할
				return o1-o2;
			}
			
		});
		System.out.println(list1);
	}

}
