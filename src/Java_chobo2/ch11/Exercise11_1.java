package Java_chobo2.ch11;   //예제 11-1

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_1 {

	public static void main(String[] args) {
		
		//ArrayList에 add 결과
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		//HashSet 타입에 ArrayList타입으로 생성해놓은 list를 집어넣는다
		HashSet set = new HashSet(list);
		
		//TreeSet 타입으로 생성한 tset에 HashSet타입으로 생성해놓은 set을 집어넣는다
		TreeSet  tset = new TreeSet(set);
		
		Stack stack = new Stack();
	//tset를 stack으로 읽어오기
		stack.addAll(tset);
		
		while(!stack.empty())
			System.out.println(stack.pop());
		

	}

}
