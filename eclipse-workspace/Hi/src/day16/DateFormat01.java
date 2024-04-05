package day16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateFormat01 {

	public static void main(String[] args) throws ParseException {
		/* TODO Auto-generated method stub
		 * 날짜를 형식에 맞춰서 문자열로 변환
		 * 문자를 날짜로 변환
		 */
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		String dateString = sdf.format(date);
		System.out.println(dateString);
		
		
		//문자를 날짜로 변환
		String dateStr = "2024-01-26 04:56:00";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date2 = sdf1.parse(dateStr);
		System.out.println(date2);
		
	}

}
