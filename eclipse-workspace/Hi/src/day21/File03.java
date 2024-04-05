package day21;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * FileWriter를 이용한 파일 쓰기
		 * 일반적으로 다시 같은 이름의 파일을 생성하면 덮어쓰기
		 * 기존 파일에 추가모드가 가능
		 * PrintWriter는 안됨
		 */
		FileWriter fw = new FileWriter("writer.txt");
		for(int i =0;i<=10;i++) {
			String data = i+ "test \r\n"; // \n은 엔터, \r은 캐리지리턴
			fw.write(data); //파일에 기록
			fw.write("my project I/O Test \r\n");
		}
		fw.close();
		
		
		//기존 파일에 데이터를 쓰려고 할 때 : 추가모드
		FileWriter fw2 = new FileWriter("writer.txt", true);
		for(int i =11; i<=20; i++) {
			String data = i+ "test \r\n"; // \n은 엔터, \r은 캐리지리턴
			fw2.write(data); //파일에 기록
			fw2.write("my project I/O Test \r\n");
		}
		fw2.close();
		
		
		//printWriter를 이용한 파일 쓰기
		PrintWriter pw = new PrintWriter("printer.txt");
		for(int i = 0;i<=10;i++) {
			String data = i+ "test \r\n";
			pw.print(data);
			pw.print("my project I/O Test \\r\\n");
		}
		pw.close();
		
		//PrintWriter를 이용하여 추가하려면
		//파일 객체를 생성해서 추가
		PrintWriter pw2 = new PrintWriter(new FileWriter("writer2.txt",true));
		
		for(int i =11; i<=20; i++) {
			String data = i+ "append mode \r\n";
			pw2.write(data);
		}
		pw2.close();
		
		//바이트 기반 스트림
		//FileoutputStream을 이용한 파일 쓰기
		FileOutputStream output = new FileOutputStream("out.txt");
		for(int i=1;i<=10;i++) {
			String data = i + "Test mode \r\n";
			//바이트 기반 스트림이기 때문에 바이트 단위로 쓰기
			output.write(data.getBytes());
		}
		output.close();
	}

}
