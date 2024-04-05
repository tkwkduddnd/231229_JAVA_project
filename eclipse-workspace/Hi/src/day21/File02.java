package day21;
import java.io.*;

public class File02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.in을 이욯하여 알파벳 하나를 쓰고
		 * Enter를 누르면 알파벳을 콘솔에 찍기
		 * 반복하기
		 */
		
		System.out.println("알파벳 입력: ");
		try {
			int i;
			while((i = System.in.read())!='\n') {
				System.out.println((char)i);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
