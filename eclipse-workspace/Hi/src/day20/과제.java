package day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 과제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//스트림으로 출력
		//여행사 상품
		//여행 비용은 15세 이상은 100만원, 그 미만은 50만원으로 계산
		//고객 3명이 패키지 여행을 떠난다고 했을 경우
		//1. 비용계산 => 출력, 2. 고객명단 검색 => 출력
		// 고객 클래스를 생성하고 , Arraylist로 고객관리
		
		//ex) 고객정보 -> 고객명단
		//이름: 이순신, 나이:40, 비용:100만원
		//이름: 이순신2, 나이:10, 비용:50만원
		//이름: 이순신3, 나이:30, 비용:100만원
		//총 여행 경비: 250만원
		
		//20대 이상 고객명단 => 이름순으로 정렬
		//이름: 이순신2, 나이:10, 비용:50만원
		//이름: 이순신3, 나이:30, 비용:100만원
		//이름: 이순신, 나이:40, 비용:100만원
		
		List<Customer> list = new ArrayList<>();
		
		list.add(new Customer("홍길동", 40, 100));
		list.add(new Customer("홍길동2", 10, 50));
		list.add(new Customer("홍길동3", 30, 100));
		
		list.stream().forEach(n->{ String name = n.getName(); int age = n.getAge();
		int price = n.getPrice();
		System.out.println(name+":"+age+"세"+":"+price+"만원");});
		
		int s =	list.stream().mapToInt(n -> n.getPrice()).sum();
		System.out.println("총 여행경비: "+s+"만원");
		
		
		System.out.println("20세 이상 사람 목록:");
		list.stream().filter(n -> n.getAge() >= 20).sorted(new Comparator<Customer>() { 
			
			@Override
			public int compare(Customer o1, Customer o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		}).forEach(n -> System.out.println(n.getName() + " : " + n.getAge() + "세 : " + n.getPrice() + "만원"));
	}
}

