package day21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File04 {

	public static void main(String[] args) throws IOException{
		/*
		 * BufferedReader : 문자 보조스트림
		 * 라인 단위로 읽기가 가능
		 * 더이상 읽을 라인이 없으면 null 리턴
		 * 보조ㅅ트림: 직접 읽고 쓰는 기능이 없기 때문에
		 * 기반스트림을 매개변수로 포함해야함
		 * 
		 */
		BufferedReader br = new BufferedReader(new FileReader("out.txt"));
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			System.out.println(line);
		}
	}

}
