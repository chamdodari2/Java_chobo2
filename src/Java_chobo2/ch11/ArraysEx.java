package Java_chobo2.ch11;  //1교시 414쪽

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class ArraysEx {  //Arrays 는 알면좋다

	public static void main(String[] args) {
//		arrayToString();
//		arrayDeepToString();		
//		arrayToEquals();		
//		arryToFill();		 
//		arrayToList();
//		arrayToBinarySearchBysort();
		
		
		// 정렬, 역순정렬하기
		Student[] stdArr = {
				new Student(1,"이종윤",90,90,90),
				new Student(5,"김길현",80,79,68),
				new Student(3,"박유진",78,91,55),
				new Student(4,"김인환",99,60,40)};
		
		//1.기본 학번순으로 정렬하기 
		Arrays.sort(stdArr); // 이건  Student 클래스에 가서  CompareTo  오버라이드 수정후나중에 추가한거
//		System.out.println(stdArr);
		prnStudent(stdArr);
		
		//2. 국어점수순으로 정렬하기
//		Arrays.sort(stdArr);  //결과 : 에러. 우리가 정의한 클래스라서 안된다.
		Comparator<Student> comp = new Comparator<Student>() {
		
			@Override
			public int compare(Student o1, Student o2) {			
				return o1.getKor()- o2.getKor();
			}
			
			
		};	
		//3.수학점수 순으로 정렬하기
		Comparator<Student> revComp = new Comparator<Student> () {			
			@Override
			public int compare(Student o1, Student o2) {		
				return  o1.getMath()- o2.getMath();
			}
		};
		Arrays.sort(stdArr, comp); 
		prnStudent(stdArr);
		
		Arrays.sort(stdArr,revComp); 
		prnStudent(stdArr);
		
			
				
			
				
		}
		
		
	

private static void prnStudent(Student[] stdArr) {
	System.out.println("정렬");
	for(Student s : stdArr) {
		System.out.println(s);
	}
	System.out.println();
}




public static void arrayToBinarySearchBysort() {
	// 
int[] arr = {10,9,5,6,7,8,1};
System.out.println(Arrays.binarySearch(arr, 8));  
System.out.println(Arrays.binarySearch(arr, 1));

//속도 차이 확인하기 sort와 parallelsort - parallelsort은 병행수행을 의미함
long start = System.nanoTime();
System.out.println("start - ");
	Arrays.sort((arr));
//	Arrays.parallelSort(arr);
	long end = System.nanoTime() - start;
	System.out.println("end -  "+ end);
	
System.out.println(Arrays.toString(arr));


System.out.println(Arrays.binarySearch(arr, 8));  
System.out.println(Arrays.binarySearch(arr, 1));
}

	public static void arrayToList() {
		//배열을 List로 변환하기	
		Integer[] intArr=(new Integer[] {1,2,3,4}); //
		System.out.println(intArr);
		
		List<Integer> arList = Arrays.asList(new Integer[] {1,2,3,4});
		System.out.println(arList.get(2));    //결과 3 뜬다.
		
		//반복문으로 돌려보기
		for(int a : arList) {
			System.out.println(a);
		}
		//특정인덱스의 값을 변경하기
		arList.set(1, 6);
		System.out.println(arList);
		
		//배열의 길이 이상으로 값을 추가하려하면 에러뜨는것 확인하기
		arList.add(10); 
		System.out.println(arList);
		
		//ArrayList로 배열로 한번 더 묶어서 변경하여 추가하면 추가될수있는것 확인
		ArrayList<Integer> al = new ArrayList<Integer> (arList);
		al.add(10);
		System.out.println(al);
	}

public static void arryToFill() {
	//배열의 복사
	int[] intArr1 = {1,2,3,4,5,6};
	int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);
	System.out.println(Arrays.toString(copyArr1));
	//배열의 데이터가 같은지 확인하기
	System.out.println(Arrays.equals(intArr1, copyArr1));
	//왼쪽에서 3개만 복사
	int[] copyArr2 = Arrays.copyOf(intArr1, 3); //3roqks
	System.out.println(Arrays.toString(copyArr2)); 
	
	//새로운 배열을 같은 데이터로 가득 채우기
	int[] newArr = new int[10];
	Arrays.fill(newArr, 10);  
	System.out.println(Arrays.toString(newArr));
	
	////만들어진 배열에 서로 다른값 넣기2
	Arrays.setAll(newArr,(i)->(int) (Math.random()*100)+1); //밑의 6줄을 한줄로 끝낸다  인덱스 i에 해당하는 값을  (int) (Math.random()*100)+1이걸로 채우라는 뜻이 된다.
	
	
	//만들어진 배열에 서로 다른값 넣기1 길게하기
	Arrays.setAll(newArr, new IntUnaryOperator() { // new 까지 적고 컨+스페이스
		
		@Override
		public int applyAsInt(int operand) {  //i, 
			
			return (int) (Math.random()*100)+1;
		}
	});
	System.out.println(Arrays.toString(newArr));  //결과 : [78, 15, 48, 16, 15, 72, 45, 11, 43, 84]
}

public static void arrayToEquals() {
	//2개의 배열이 같은지 확인하기 - 원래는 반복문돌려야 하는데 한줄로 하기
	int[] intArr1 = {1,2,3};   
	int[] intArr2 = {1,2,3};
	System.out.println(Arrays.equals(intArr2, intArr1));
	//2차원 배열이 같은지 확인하기
	int[][] intTwoDiemn1 = {{1,2},{3,4}};
	int[][] intTwoDiemn2 = {{1,2},{3,4}};
	System.out.println(Arrays.deepEquals(intTwoDiemn1,intTwoDiemn2));
}

public static void arrayDeepToString() {
	int[][] twoArr = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
			};
	System.out.println(Arrays.toString(twoArr));  // [[I@15db9742, [I@6d06d69c, [I@7852e922]
	System.out.println(Arrays.deepToString(twoArr));  // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
}

public static void arrayToString() {
	//List를 array로 변환해주는것임. (ArrayList)
	ArrayList <String> arList = new ArrayList <String>();
	arList.add("abc");
	arList.add("def");
	arList.add("ghi");
	
	//배열로바꾸기
//		arList.toArray(); /Object[] java.util.ArrayList.toArray()   --> 오브젝트배열을 던져주고있다. 
	Object[] objArr = arList.toArray();
	System.out.println(Arrays.toString(objArr));   //투스트링은 배열안에 있는것을 문자로 돌려준다. 
	//
	String str = Arrays.toString(objArr);
	System.out.println("objArr to String > "+ str);
	// List를 배열로 바꿔서 보자는거임
	String[] strArr = new String[arList.size()];  //해당사이즈만큼 출력 (length랑 비슷한듯)
	arList.toArray(strArr); //strArr에 넣어준다
	System.out.println(Arrays.toString(strArr)); //출력은 똑같이 된다. 처음부터 선언을 해서 받느냐 요소만큼 배열로 선언해서 받느냐 차이(?)
}

}
