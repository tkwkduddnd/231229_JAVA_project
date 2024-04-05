package day20;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda01 {

	public static void main(String[] args) {
		/*
		 * lambda : 람다식(식을 단순하게 표현하는 방법)
		 * 
		 * Lambda + Stream => 람다와 스트림
		 * Stream : 자료의 대상과 관계없이 동일한 연산을 수행할 수 있도록 해주는 반복자
		 * 
		 * lambda functions : 람다 함수 => 익명 클래스를 사용하여 쓰는 함수
		 * 람다의 장점: 코드의 간결성, 병렬처리 가능, 불필요한 연산 최소화
		 * 단점: 가독성이 떨어짐, 반복문 사용시 성능 저하
		 * - 람다의 표현식
		 * (매개변수) -> {구현}
		 * 매개변수가 1개면 () 생략 가능
		 * x -> {return x+1; }
		 * x -> return x+1; //리턴이 있는데 중괄호 생략하면 오류 발생
		 * x,y -> x+y; // 오류 발생
		 * 리턴이 없으면 {} 생략 가능
		 * x -> x+1;
		 * (x,y) -> x+y;
		 * (x,y) -> {return x+y; }
		 */
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(50);
		list.add(30);
		list.add(60);
		list.add(90);
		list.add(20);
		list.add(40);
		
		for(Integer tmp : list) {
			System.out.print(tmp+" ");
		}
		System.out.println();
		System.out.println("-----------------");
		
		list.forEach(n->{
			System.out.print(n+" ");
		});
		System.out.println();
		
		
		Consumer<Integer> method = (n)->{
			System.out.print(n+" ");
		};
		System.out.println();
		list.forEach(method);

	}
}
