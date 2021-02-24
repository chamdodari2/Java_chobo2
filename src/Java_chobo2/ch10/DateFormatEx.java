package Java_chobo2.ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  //컨 쉬 O

public class DateFormatEx {
	
	public static void main(String[] args) throws ParseException {
		Date toDay = new Date();
		System.out.println(toDay);  // 출력결과 : Tue Feb 16 14:51:56 KST 2021

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a K시"); // 출력결과: 2021년 02월 16일 화요일 오후 2시
		System.out.println(sdf.format(toDay));
		
		String str = "2021년 02월 16일";
		sdf.applyPattern("yyyy년 MM월 dd일"); 
		System.out.println(sdf.parse(str));  //한글이 들어가면 출력되지 않음 출력결과 : Tue Feb 16 00:00:00 KST 2021
	}

}
