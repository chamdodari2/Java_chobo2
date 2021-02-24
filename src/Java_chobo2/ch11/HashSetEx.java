package Java_chobo2.ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class HashSetEx {

	public static void main(String[] args) {
		//
		
		HashSet<Integer> set = new HashSet<Integer>();
		Random rnd = new Random(1234);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i <10;i++) {
			int r = rnd.nextInt(5);
			list.add(r);  //List는 중복이 되는것 확인가능
			set.add(r);   //set 중복이 안되는것 확인가능
		}
		
System.out.println(list);
System.out.println(set);
	}

}
