package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List02 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * 두 배열을 입력받아서 하나로 합치는 ArrayList 생성
		 * 정렬하여 출력
		 */
		String arr1[] = new String[] {"a","c","f","b"};
		String arr2[] = new String[] {"d","g","h","k"};
		
		int arr3 = arr1.length + arr2.length;
		int i=0;
		int j=0;
		
		List<String> list = new ArrayList<String>();
		
		while(arr3 > list.size()) {
			if(i<arr1.length) {
				list.add(arr1[i]);
				i++;
			}
			if(j<arr2.length) {
				list.add(arr2[j]);
				j++;
			}
		}
		System.out.println(list);
		
		
		
		Collections.sort(list);
		System.out.println(list);

	}

}
