package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 과제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("값을 입력: ");
		List<Integer> list = new ArrayList<Integer>();
		
		String num = "45,25,51,71,64,98";
		String[] numbers = num.split(",");
		
		for(String n : numbers) {
			list.add(Integer.parseInt(n));
		}
		System.out.println(list);
		int sum = 0;
		int count = 0;
		for(int tmp : list) {
			sum+=tmp;
			if(tmp>70) {
				count++;
			}
		}
		System.out.println("총합: "+sum);
		System.out.println("70점 이상 인원수 : "+count);
		scan.close();
	}

}
