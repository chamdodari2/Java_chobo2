package Java_chobo2.ch14.stream;  //배열 & 리스트 데이터의 정렬및 출력방법 통일하기- 스트림을 통하여

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String[] args) {
		String[] strArr  = {"aaa","ddd","ccc"};  //배열
		List<String> strList = Arrays.asList(strArr);  //리스트
		
		
		System.out.println(Arrays.toString(strArr));
		System.out.println(strList);
		
		//1.그냥 정렬해보기
		Arrays.sort(strArr);  //정렬
		System.out.println(Arrays.toString(strArr));
		
		Collections.sort(strList);
		System.out.println(strList);
		
		//1.1 스트림으로  생성하여 정렬해보기
		String[] strArr2  = {"aaa","ddd","ccc"};//생성
		List<String> strList2 = Arrays.asList(strArr);
		
		Stream<String> strStream1 = Arrays.stream(strArr2);// 배열의 스트림생성  
		Stream<String> strStream2 = strList2.stream();		//리스트의 스트림생성?
		
		strStream1.sorted().forEach(System.out::println); //정렬및 출력 -> 여기서 스트림 사용된것이다. 최종연산일 경우 이제 재사용하려면 다시생성해야함
		strStream2.sorted().forEach(System.out::println);
		
		
		//스트림 특징
		//1. 스트림은 데이터 소스로부터 데이터를 읽기만 할뿐 변경하지 않는다.
		List<String> list =  strList2.stream().sorted().collect(Collectors.toList());// 새로운 리스트에 저장
		System.out.println(list);
		
		//2.스트림은 terator처럼 일회용이다. 필요하면 다시 스트림을 생성해야함
		//strStream1.sorted().forEach(System.out::println);
		//위 코드에서 사용했으므로 불가능.
	//	long cnt = strStream1.count();
	//	System.out.println(cnt);
			
		//스트림을 다시 생성한 후 적용하기
	long cnt = Arrays.stream(strArr2).count();
	System.out.println(cnt);
		
		//지연된 연산  (최종연산 전까지는 중간연산이 수행되지 않음)
		IntStream intStream = new Random().ints(1, 46);  //1부터 46까지 생성하기. 제네릭안써두도니다
		
		intStream.distinct().limit(6).sorted()   // --->여기까지가 중간연산
		.forEach(i->System.out.print(i+", "));// --> 이건 최종연산
		
		System.out.println();
		//이렇게 쓰기도 한다. 한줄로 안써도 되더라
		intStream = new Random().ints(1, 46);
		intStream
		.distinct()
		.limit(6)
		.sorted()
		.forEach(i->System.out.print(i+","));
		
		//  스트림의 작업을 병렬로 처리		
		Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
		int sum = strStream.parallel()//병렬 스트림으로 전환 (속성만 변경)
				.mapToInt(s->s.length()).sum(); //모든 문자열의 길이의 합
		System.out.println("sum" + sum);
	}

}
