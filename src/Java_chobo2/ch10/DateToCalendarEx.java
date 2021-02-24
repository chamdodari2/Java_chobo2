package Java_chobo2.ch10;// Data와 Calendar 간의 변환

import java.util.Calendar;
import java.util.Date;

public class DateToCalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2020, 0, 1);
		System.out.println(
				cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH)); // -1부터 시작되기 때문에 +1을 해주어야한다.

		Date d = new Date();
		d.setYear(19);
		d.setMonth(0);
		d.setDate(1);
		System.out.printf("%tF %n", d);

		convCalToDate(cal);
		convDateToCal(d);

	}

	private static void convCalToDate(Calendar cal) {// 데이터타입으로 변환하기 메소드
		System.out.println("convert Calendat To Date()");

		Date d = new Date(cal.getTimeInMillis());
		System.out.printf("%tF %n", d);

	}

	private static void convDateToCal(Date d) {// 캘린더타입으로 변환하기 메소드
		System.out.println("convCalToDate()");

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH));
	}

}
