package day16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Date02 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 
		 */
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		String t = today.toString(); // toString으로 객체를 변환
		System.out.println(t);
		//날짜 2024-01-26 / 시간 17:03:34
		
		System.out.println("----------------------------------------------------");
		String date = t.substring(0,t.indexOf("T"));
		System.out.println(date);
		String time = t.substring(t.indexOf("T")+1, t.indexOf("."));
		System.out.println(time);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		LocalDateTime sDate = LocalDateTime.of(2009, 9,30,8,30); //날짜 생성
		System.out.println(sDate.format(dtf));
	}

}
