package Java_chobo2.ch11;  //반복문은 Integer 사용해야한당  자료구조 어레이리스트 말고 해시로도 쓸수있어야한다.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListEx {

	public static void main(String[] args) {
	//	extracted();
		
		HashMap<Integer,Department> deptHash = new HashMap<>();
		deptHash.put(1, new Department(1,"기획",20));
		deptHash.put(2, new Department(2,"개발",21));
		deptHash.put(3, new Department(3,"인사",22));
		deptHash.put(4, new Department(4,"총무",23));
		System.out.println(deptHash);  //키값 벨류 뜬다.
		
		Iterator<Entry<Integer,Department>>i = deptHash.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Integer,Department > e = i.next();
			System.out.println(e.getKey()+ " ");
		//	System.out.println(e.getValue()); 이방법 또는 아랫줄 방법
			System.out.println(deptHash.get(e.getKey()));
		}
		

}

	public static void extracted() {
		ArrayList objList = new ArrayList();				 //?는 오브젝트가 된다. 다 담을수있다
		objList.add("aa");
		objList.add(1);
		objList.add(new Department(1,"최순실",10));  		//반복문 돌리려면 타입캐스트 해야한다
		
		Iterator i = objList.iterator();
		while(i.hasNext()) {
			Object obj = i.hasNext();
			System.out.println(obj);
		}
		/*
		 * }ArrayList<Department> deptList = new ArrayList<>(); deptList.add(new
		 * Department(1,"기획1",10)); deptList.add(new Department(2,"기획2",20));
		 * deptList.add(new Department(1,"기획3",30));
		 * 
		 * Iterator<Department> iDept = deptList.iterator(); while(iDept.hasNest()) {
		 * System.out.println(iDept.next()); }
		 */
	}
}