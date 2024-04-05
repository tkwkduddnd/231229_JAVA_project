package day17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * 과목과 점수를 입력 받아(Scanner) map에 저장 후 출력
		 * 합계, 평균 출력
		 * 종료 키워드가 나올때까지 반복(종료 키워드=0, 1=계속 입력)
		 * ex) 과목과 점수를 입력해주세요 ->
		 * 국어 89
		 * 수학 78
		 * 0 종료
		 * map으로 저장 후 출력
		 */
		
		HashMap<String, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = sum/5;
		String subject;
		
		
		System.out.println("과목과 점수를 입력하세요 ->");
		scan.nextInt();
		
		while(true) {
			if(score == 0) {
				System.out.println("종료");
			}
			else {
				System.out.println("계속 진행");
			}
			
		
		for(String key : map.keySet()) {
			 
			System.out.println(key+":"+map.get(key));
		}
		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+":"+map.get(subject));
		}
		System.out.println("----------------");
		System.out.println("합계: "+sum);
		System.out.println("평균: "+avg);
		
		

	}

}
