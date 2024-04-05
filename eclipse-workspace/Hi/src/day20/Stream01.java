package day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Stream01 {

	public static void main(String[] args) {
		/*
		 * Stream(스트림)
		 * - 실제 입력 / 출력이 표현된 데이터의 이상화된 흐름
		 * - 스트림은 자료에 대한 스트림을 생성하여 연산
		 * - 그 연산을 다 수행하면 스트림은 소모됨
		 * - 스트림은 기존 자료를 복사하여 복사본은 연산에 사용
		 * - 중간연산과 최종연산으로 구분됨
		 * - 중간연산은 메소드를 이어서 사용할 수 있음
		 * - distinct(), filter(), limit(), skip(), peek(), sorted() 등
		 * - distinct(): 중복 제거
		 * - filter(): 조건에 맞는 값만 다음 스트림으로 넘김
		 * - limit(): 스트림의 일부를 잘라냄
		 * - skip(): 스트림의 일부를 건너뜀
		 * - peek(): 작업 수행
		 * - sorted(): 정렬
		 * - 최종연산은 마지막에만 사용
		 * - forEach(), count(), sum(), allMatch(), anyMatch(), toArray() 등
		 */
		int arr[] = new int[]{15,32,46,28,71,55,93};
		int sum=0;
		
		for(int i: arr) {
			sum += i;
			
		}
		System.out.println(sum);
		System.out.println("----스트림을 이용한 합계-----");
		
		int total = Arrays.stream(arr).sum();
		System.out.println(total+" ");
		
		System.out.println("--스트림 count()--");
		long cnt = Arrays.stream(arr).count();
		System.out.println(cnt);
		System.out.println("--스트림 average()---");
		
		OptionalDouble avg = Arrays.stream(arr).average();
		System.out.println(avg);
		
		
		// arr 값중 5이상의 값만 합계
		int s5 = Arrays.stream(arr).filter(n-> n>=5).sum();
		System.out.println(s5);
		//점수 배열을 생성한 후 70점 이상(filter)만 합계, 평균
		int arrA[] = new int[]{15,32,46,28,71,55,93};
		int arr1 = Arrays.stream(arrA).filter(n-> n>=70).sum();
		OptionalInt max = Arrays.stream(arrA).max();
		
		OptionalDouble avg1 = Arrays.stream(arr).filter(n-> n>=70).average();
		System.out.println(arr1);
		System.out.println(avg1);
		System.out.println(max);
		
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(7);
		list.add(7);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(8);
		list.add(9);
		list.add(3);
		System.out.println("list를 stream으로 구성");
		list.stream().forEach(n->System.out.print(n+" "));
		System.out.println("distinct()---중복제거");
		list.stream().distinct().forEach(m-> System.out.println(m+" "));
		
		list.stream().sorted().forEach(n-> System.out.print(n+" "));
		
		System.out.println("--스트림 객체 생성 -- ");
		Stream<Integer> s1 = Stream.of(10,20,30,40,50,60,70);
		System.out.println("Integer Stream 합계");
		//map : 스트림 형변환에 사용하는 중간연산
		int s = s1.mapToInt(n -> n.intValue()).sum();
		System.out.println(s);
		//s1.forEach(n-> System.out.print(n+" ")); // s1은 두번 사용 불가
	}

}
