package Java_chobo2.ch10;

import java.util.Calendar;

public class Ex10_1 {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println("이 해의 년도 : "+ today.get(Calendar.YEAR));
		System.out.println("월(0~11, 0 : 1월) : "+ today.get(Calendar.MONTH));
		System.out.println("이 해의 몇째 주 : " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 :" + today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이 달의 몇 일 :" + today.get(Calendar.DATE));
		System.out.println("이 달의 몇 일:" + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇 일 :" + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("이 달의 몇째 요일) :" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("요일(1~7, 1:일요일) :" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("요일(1~7, 1:일요일) :" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("요일(1~7, 1:일요일) :" + today.get(Calendar.DAY_OF_WEEK));
		System.out.println("이 달의 몇째 요일) :" + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		
		

	}

}
