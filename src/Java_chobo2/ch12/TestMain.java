package Java_chobo2.ch12;

import java.util.ArrayList;

public class TestMain { //사용할때

	public static void main(String[] args) {
		//box에 있는걸 다 string으로 바꾸기
		Box<String> box = new Box<String>();  
		box.add("abc");
		box.add("def");
		
		
		String item = box.get(0);
		System.out.println("item > " + item);
		//list안에 있는 두줄의 문장을 매개변수로 각각 넣어준다. 세줄적는대신 한줄로 처리!!
		ArrayList <String> list = box.getList();
		list.stream().forEach(System.out::println);
		
		System.out.println(box);
	}

}
