package Java_chobo2.ch10;  //13,14줄이 키포인트. 교재 378 

import java.text.DecimalFormat;//결과를 텍스트로ㅓ 돌려준다
import java.text.ParseException;


public class NumberToStringEx {

	public static void main(String[] args) throws ParseException {
	//	extractedMethod();
		
		//pattern : #,###
		//1234567 	을  ->  format(pattern) pattern : #,### 이용하여 "123,567" 으로 표시하기  키포인트!!
		//"123,456" 을 ->	   partce(pattern) : pattern : #,###을 이용하여 123567으로 표시하기 키포인트!!!
		
		
		//숫자를 -> 문자로 표시 (format)
			int salary = 12345678;	
			DecimalFormat df = new DecimalFormat("#,###.#");  //salary를  DecimalFormat  또는 String.format 이용해 구분기호 찍어주기 
			System.out.println(df.format(salary));  
			System.out.printf("%,d%n",salary);  // %,이 세자리 구분기호라 이것도 쉼표 찍어주기
			String str = String.format("%,d%n", salary); //이 방법도 된다
			System.out.println(str);
			String strDbl = String.format("%,.2f", 1234.56); //소수점 2자리까지 표시
			System.out.println(strDbl);
			
			//문자를 -> 숫자로 표시   (parse) 
			String strNum = "123,456";  //strNum을   //parse를 이용해 문자를 숫자로 표시
			DecimalFormat df2 = new DecimalFormat("0,000");
			int i  = df2.parse(strNum).intValue();   //이렇게 연쇄적으로 써도 된다.
//			Number s = df2.parse(strNum);
//			int i = s.intValue();	
			System.out.println("i = "+ i);
			
	}

	public static void extractedMethod() throws ParseException {
		
		
		
		double number = 1234567.89;
		System.out.println("number > "+number);
		
		
		DecimalFormat  df = new   DecimalFormat();
				df.applyPattern("#,###.#");
				
				
				String str = df.format(number);
				System.out.println(str);
				
				df.applyPattern("000000000.0");
				System.out.println(df.format(number));
				
				df.applyPattern("#########.#");
				System.out.println(df.format(number));
				
				df.applyPattern("#.#E0");  //한자리까지 표시  1234567.89 => 1.2*10^6승   (E로 표시한것)
				System.out.println(df.format(number));
				
				Number numberStr =df.parse("1.2E6");  //이거를 숫자형태로 바꿔주기
				Double d = numberStr.doubleValue();
				System.out.println(d);
				df.applyPattern("#,###.0");  //표시형식 변경
				numberStr = df.parse("123,456.55");  // 문자열에서 파스를 이용해서  숫자로 돌려받기
				d = numberStr.doubleValue();
				System.out.println(d);  //쉼표가 없어진것을 확인가능
	}

}
