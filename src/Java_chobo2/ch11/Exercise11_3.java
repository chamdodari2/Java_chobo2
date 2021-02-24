package Java_chobo2.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Exercise11_3 {

	public static void main(String[] args) {
		ArrayList<Ex_11_3_Student> list2 = new ArrayList<Ex_11_3_Student>();
		list2.add(new Ex_11_3_Student("홍길동", 1, 1, 100, 100, 100));
		list2.add(new Ex_11_3_Student("남궁성", 1, 2, 90, 70, 80));
		list2.add(new Ex_11_3_Student("김자바", 1, 3, 80, 80, 90));
		list2.add(new Ex_11_3_Student("이자바", 1, 4, 70, 90, 70));
		list2.add(new Ex_11_3_Student("안자바", 1, 5, 60, 100, 80));
		 
		Collections.sort(list2);
		Iterator<Ex_11_3_Student> it = list2.iterator();
	
		while (it.hasNext())
			System.out.println(it.next());
	}
}