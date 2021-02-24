package Java_chobo2.ch11; //이퀄즈랑 해시코드 오버라이드 해야한다 강조!!!! (api를 봤을때 이퀄즈 오버라이딩 적혀있으면 생각해내야한다!!)
//주석해제는 컨쉬 |

import java.util.ArrayList;
import java.util.Comparator;

class Department {
	private int deptNo;
	private String deptName;
	private int foor;

	public Department(int deptNo, String deptName, int foor) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.foor = foor;
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, deptName, foor);
	}

}

public class ArrayListEx {

	public static void main(String[] args) {
//		extractedMethod01();	

		ArrayList<Department> deptList = new ArrayList<Department>();
		deptList.add(new Department(1, "기획", 20));
		deptList.add(new Department(2, "개발", 10));
		deptList.add(new Department(3, "인사", 30));

		prnList(deptList);

//		deptList.remove(new Department(2)); // 뭘로 비교해야할지 명시를 안해놔서 안된다 -> 컨쉬 s - >이퀄즈 오버라이드
//		prnList(deptList);

		int idx = deptList.indexOf(new Department(2, "개발", 10));
		System.out.println("idx " + idx);

		boolean isContain = deptList.contains(new Department(2, "개발", 10));
		System.out.println("isContain " + isContain);

		Department upDept = new Department(2, "마케팅", 11);
		deptList.set(deptList.indexOf(upDept), upDept);
		prnList(deptList);

	}

	private static void prnList(ArrayList<Department> deptList) {
		for (Department d : deptList) {
			System.out.println(d);
		}
		System.out.println();
	}

	public static void extractedMethod01() {
		ArrayList<Integer> arList = new ArrayList<>(); // 걍어레이리스트하면 타입캐스트 해주야함 <타입>넣어주기 클래스만 가능하다
		System.out.println(arList);

		// 추가
		arList.add(10);// autocobxing
		arList.add(20);
		System.out.println(arList);
		System.out.println(arList.size());

		arList.add(1, 40);
		System.out.println(arList);
		System.out.println(arList.size());

		System.out.println("40index " + arList.indexOf(40)); // 해당 값이 위치한 인덱스 위치확인
		arList.remove(1);
		System.out.println(arList);
		System.out.println(arList.size());

		arList.add(50);
		arList.add(60);
		System.out.println(arList);

		arList.remove(new Integer(50)); // 50만 넣으면 에러뜬다. new 인티저 해주야함
		System.out.println(arList);

		for (int a : arList) { // 오토언박싱
			System.out.println(a); // 10 20 60 출력된다

			for (int i = 0; i < arList.size(); i++) { // 결과 똑같이 10 20 60 출
				System.out.println(arList.get(i));
			}
		}
		arList.set(1, 40); // 인덱스가 1인 곳을 40으로 변경
		System.out.println(arList);

		if (arList.contains(30)) {// 30을 포함하고있느냐?
			System.out.println("30있음");
		} else {
			System.out.println("30 없음");
		}
		System.out.println(arList.contains(60));
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("c");
		strList.add("b");

		System.out.println(strList); // a,c,b 그대로 출력된다
		strList.sort(new Comparator<String>() { // a,b,c 순서대로 정렬해서보기

			@Override
			public int compare(String o1, String o2) {
				return o1.hashCode() - o2.hashCode(); // 'a','b' 비교하기 -> 97-98로 한다. (아스키코드) 반대로 하면 역순정렬

			}
		});
		System.out.println(strList);
	}
}