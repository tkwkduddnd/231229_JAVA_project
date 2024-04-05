package day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 과제1 {

	public static void main(String[] args) {
		
		List<Customer1> list = new ArrayList<>();
		
		list.add(new Customer1("홍길동", 40, 100));
		list.add(new Customer1("홍길동2", 10, 50));
		list.add(new Customer1("홍길동3", 30, 100));
		
		list.stream().forEach(n->{ String name = n.getName(); int age = n.getAge();
		int price = n.getPrice();
		System.out.println(name+":"+age+"세"+":"+price+"만원");});
		
		int s =	list.stream().mapToInt(n -> n.getPrice()).sum();
		System.out.println("총 여행경비: "+s+"만원");
		
		
		System.out.println("20세 이상 고객 목록:");
		list.stream().filter(n -> n.getAge() >= 20).sorted(new Customer1.cusComparator()).forEach(n -> System.out.println(n.getName() + " : " + n.getAge() + "세 : " + n.getPrice() + "만원"));
	}
}
