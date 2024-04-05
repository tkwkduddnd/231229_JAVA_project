package day20;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Stream02 {

	public static void main(String[] args) {
		/*
		 * 배열에서 짝수만 출력(정렬) 중복되는 값 제거
		 */
		int arr[] = {1,6,4,8,4,2,5,6,7,4,3,2,1,7,8,4,6};
		Arrays.stream(arr).sorted().distinct().filter(n-> n%2==0).forEach(n-> System.out.println(n+" "));
		//배열로 리턴
		
		int result[] = Arrays.stream(arr)
		.filter(a -> a%2==1)
		.sorted()
		.distinct()
		.toArray();
		for(int tmp : result) {
			System.out.print(tmp+" ");
		}
		
		
		
		
		
		
	}
	
}
