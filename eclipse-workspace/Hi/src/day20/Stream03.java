package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream03 {

	public static void main(String[] args) {
		/*
		 * Student 클래스로 리스트 구성
		 * add로 5명 추가
		 * 스트림을 이용하여 콘솔에 출력 ex) 홍길동 : 98
		 */
		
		
		List<Student> list = new ArrayList<>();
		
		
		list.add(new Student("홍길동", 90));	
		list.add(new Student("홍길동2", 61));	
		list.add(new Student("홍길동3", 85));	
		list.add(new Student("홍길동4", 57));	
		list.add(new Student("홍길동5", 80));	
		
		list.stream().forEach(n->System.out.print(n+" "));
		System.out.println();
		list.stream().forEach(n->{ String name = n.getName(); int score = n.getScore(); 
		System.out.println(name+":"+score);});
		
		//list의 점수 합계와 전체 인원수 출력
		
		int s =	list.stream().mapToInt(n -> n.getScore()).sum();
		System.out.println(s);
		
		long count = list.stream().count();
		System.out.println(count);
	
		
		
		
		
	}
	
	

}
