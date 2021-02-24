package Java_chobo2.ch11;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		
		//학번을 통해서 저장하기
		HashMap<Integer,Student> map = new HashMap<>();
		Student std1 = new Student(1,"유한솔",90,80,70);
		Student std2 = new Student(2,"이태훈",91,81,70);
		Student std3 = new Student(3,"김재룡",92,82,70);
		Student std4 = new Student(4,"신범건",93,83,70);
		Student std5 = new Student(5,"김경연",94,84,70);
		
		map.put(std1.getStdNo(), std1);   //추가하기
		map.put(std2.getStdNo(), std2);
		map.put(std3.getStdNo(), std3);
		map.put(std4.getStdNo(), std4);
		map.put(std5.getStdNo(), std5);
		//출력하기
		prnMap(map);
		
		//수정하기
		Student std6 = new Student(3, "김재령", 90, 88, 77);  //변경할?? 하지않은 ?? 정보를 입력받은것 : 3번의 정보를 이 정보로 바꿔달라는거
		map.replace(std6.getStdNo(), std6);   //std6.getStdNo() 에 있는걸 std6으로 바꿔달라
		prnMap(map);
		
		//해당 값이 존재하는지 확인  >> 
		boolean isExists = map.containsKey(3);
		System.out.println(isExists);
		// 삭제하기
		map.remove(3);
		
	}
	//
	
	private static void prnMap(HashMap<Integer, Student> map) {
		System.out.println("==== Set");
		Set<Entry<Integer,Student>> s = map.entrySet();  //리턴타입 set 안의
		for(Entry<Integer,Student> e : s) {// 한개씩 받기
			System.out.println(e.getKey() + " > "+ e.getValue());
		}
		System.out.println();
		
		//ket로도  해보기. 결과는 똑같다.
		Set<Integer> keySet = map.keySet();
		for(Integer key :keySet) {
			System.out.println(key + " > "+ map.get(key));
			
		}
	}

}
