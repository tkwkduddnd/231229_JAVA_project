package day16;

import java.util.Date;

import java.util.Calendar;

public class Data01 {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub
		 * 날짜/ 시간 클래스
		 * Date 클래스 => Deprecated(비권장) / Calender 클래스
		 * 추상클래스를 구현한 객체를 이용할 때 사용
		 * new로 객체 생성 불가능
		 * getinstance() 메소드를 이용하여 객체를 얻어옴
		 * static 메솓,. 클래스명.메소드명()
		 */
		
		//Date d = new Date();
		Calendar c = Calendar.getInstance(); // 오늘 날짜 리턴
		int Year = c.get(Calendar.YEAR);
		System.out.println(Year);
		
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		
		System.out.println(Year + "-" + month + "-" + day);
		
		
		//hour, minute, second, am_pm
		
		//2024-1-26 (금)
		//오후 4:13
		int hour = c.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);
		
		int minute = c.get(Calendar.MINUTE);
		System.out.println(minute);
		
		int second = c.get(Calendar.SECOND);
		System.out.println(second);
		
		int am_pm = c.get(Calendar.AM_PM);
		
		System.out.println("---------------------");
		System.out.println(Year + "-" + month + "-" + day);
		System.out.println(am_pm + " " + hour +":"+minute);
		
		String weekstr = null;
		
		switch(week) {
		case 1:
			weekstr = "일";
			break;
		case 2:
			weekstr = "월";
			break;
		case 3:
			weekstr = "화";
			break;
		case 4:
			weekstr = "수";
			break;
		case 5:
			weekstr = "목";
			break;
		case 6:
			weekstr = "금";
			break;
		case 7:
			weekstr = "토";
			break;
			default:
			break;
			
			//System.out.println(Year + "-" + month + "-" + day+" "+weekstr);
			//System.out.println((am_pm==0?"오전":"오후")+hour+minute+second);
		}
		
	}

}
