package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFinalEx3 {

	public static void main(String[] args) {

//		List<Student> list = new ArrayList<Student>();
//		list.add(new Student("이자바", 3, 300));
//		list.add(new Student("김자바", 1, 200));
//		list.add(new Student("안자바", 2, 100));
//		list.add(new Student("박자바", 2, 150));
//		list.add(new Student("소자바", 1, 200));
//		list.add(new Student("나자바", 3, 290));
//		list.add(new Student("감자바", 3, 80));
		
		
		//스트림을 reducing
		//나온값중에 최대값
		OptionalInt maxValue = new Random(1234).ints(1,46)
		.distinct().limit(6)
		.peek(s -> System.out.printf(s + ", "))  //39, 24, 1, 36, 34, 5
		.reduce(Integer::max); //로또번호쓰
		
//		System.out.println("max = "+maxValue.getAsInt());  //최대값인 39 출력
		
		Optional<Integer> maxValue2 = new Random(1234).ints(1,46)
				.distinct().limit(6)  //여기까지가 StreamInt(마우스 올려보면 나옴)
				.boxed()  //여기를 통해서 Stream<Integer>로 바뀐다. boxed에 의해서
				.peek(s -> System.out.printf(s + ", "))
				.collect(Collectors.reducing(Integer::max));
		
		System.out.println("max = "+maxValue.getAsInt());  //
		System.out.println("max = "+maxValue2.get());  //최대값인 39 출력
				
		//
		int sum1 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.reduce(0,(a,b)->a+b);
		
		//
		int sum2 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.boxed()
				.collect(Collectors.reducing(0,(a,b)->a+b));
				
		System.out.printf("sum1 = %d, sum2 = %d%n",sum1,sum2); //sum1 = 139, sum2 = 139
		//스트림으로 점수를 누적시키기
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));
	
		int grandTotal1 = list.parallelStream()
		.map(Student::getTotalScore)
		.reduce(0,Integer::sum);
		
		System.out.println(grandTotal1);
		
		int grandTotal2 = list.parallelStream()
				.collect(Collectors.reducing(0,Student::getTotalScore,Integer::sum));

				
				System.out.println(grandTotal2);
		//문자열스트림을 모두 연결(Joinning)
			
		String names1 = list.parallelStream().map(Student::getName)
			.collect(Collectors.joining());

		String names2 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(","));
		
		String names3 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(",","[","]"));
		
		
//		String studentInfo = list.parallelStream()
//				.collect(Collectors::joining(","));  //Student의 toString()으로 결합?? 안된당. 지우기
				
		System.out.println(names1);
		System.out.println(names2);
		System.out.println(names3);
				
		
	}
}
