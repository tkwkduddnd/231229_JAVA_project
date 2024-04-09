package new_java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 단어장
		 * map으로 생성
		 * 입력받을 단어의 개수를 입력받아 개수만큼 map에 추가
		 * 콘솔에 출력
		 */
		
		HashMap<String, String> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("단어의 개수를 입력: ");
		int wordnum = scan.nextInt();
		
		while(map.size() < wordnum) {
			System.out.println("단어: ");
			String word = scan.next();
			System.out.println("뜻: ");
			String mean = scan.next();
		}
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String word = it.next();
			System.out.println(word+":"+map.get(word));
		}
		
		
	      scan.close();

	}

}
