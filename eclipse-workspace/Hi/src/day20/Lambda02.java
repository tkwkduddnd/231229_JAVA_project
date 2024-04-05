package day20;

import java.util.HashMap;
import java.util.function.Consumer;

public class Lambda02 {

	public static void main(String[] args) {
		//map을 구성하여 foreach를 사용하여 출력
		HashMap<String, Integer> map = new HashMap<>();
		map.put("길동", 89);
		map.put("길동2", 69);
		map.put("길동3", 39);
		map.put("길동4", 19);
		map.put("길동5", 59);
		
		
		
		map.forEach((x,y)->{
			System.out.println(x+":"+y);
		});
		System.out.println();
		
		Number sum = (a, b) -> {
			return a+b;
			};
			int hap = sum.add(50, 60);
			System.out.println(hap);
		
		System.out.println(sum.add(100, 200));
		
		Number max = (a,b) -> 
		(a>=b)? a:b;
		System.out.println(max.add(50, 20));
	}

}

//함수형 인터페이스 생성
//메소드가 1개여야만 함
@FunctionalInterface
interface Number{
	int add(int a, int b);
}
