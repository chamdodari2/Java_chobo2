package Java_chobo2.ch14.stream;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
//		extracted01();  // 중간연산 skip,limit,filter,distinct
		
//		extracted02();
		
		extracted03(); //sorted
		
				 
		
		
		
	}

	public static void extracted03() {
		Stream<Student> stdStream = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("안자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("감자바",3,180)
				);
				//기본은 총점인데 바꾸겠다
//			stdStream.sorted(Comparator.comparing(Student::getBan) //반별정렬로
//				.thenComparing(Comparator.naturalOrder()))  //얘는  ㅁ호출
//			.forEach(System.out::println);  //기본정렬
//				System.out.println();
			//
			stdStream
			.sorted(Comparator.comparing(Student::getBan) //
					.thenComparing(Student::getName))  // 반별정렬하고,
				.forEach(System.out::println);  //이름순으로 하고 가나다순으로 정렬해달라
	}

	public static void extracted02() {
		//방법1
		Stream<String>  strStream = Stream.of("dd","aaa","CC","cc","b");
		strStream.sorted().forEach(s -> System.out.print( s+ " "));
		System.out.println();
		//방법2
		Stream.of("dd","aaa","CC","cc","b")
		.sorted(Comparator.naturalOrder())
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
	
		//방3
		Stream.of("dd","aaa","CC","cc","b")
		.sorted((s1,s2)-> s1.compareTo(s2))
		.forEach(s -> System.out.print( s+ " "));
		
		//방법4
		Stream.of("dd","aaa","CC","cc","b")
		.sorted((String::compareTo))
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
		
		//
		Stream.of("dd","aaa","CC","cc","b")
		.sorted(Comparator.reverseOrder())
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
		//
		/*
		 * Stream.of("dd","aaa","CC","cc","b") .sorted(String.CASE_INSENSITIVE_ORDER))
		 * forEach(s -> System.out.print( s+ " ")); System.out.println(); //
		 * Stream.of("dd","aaa","CC","cc","b")
		 * .sorted(String.CASE_INSENSITIVE_ORDER.reversed()) forEach(s ->
		 * System.out.print( s+ " ")); System.out.println();
		 */
	}

	public static void extracted01() {
		//중간연산
		//1. skip()limit()
		System.out.println("중간 연산 - 1. skip(), 2. limit()");
		IntStream.rangeClosed(1, 10)
		.skip(3).limit(5)
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
	
		
		//2 filter,distinct
		System.out.println("중간 연산 - 2.filter(), distinct()");
		IntStream.of(1,2,2,3,3,3,4,5,5)
		.distinct().forEach(s -> System.out.print( s+ " "));
		System.out.println();
		//2dㅢ 짝수만 출력하기
		IntStream.rangeClosed(1, 20)
		.filter(i->i%2==0)  //순차실행이므로 2의 배수중에서
		.filter(i->i%3==0)	//3의 배수는 제거해라
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
		
		//람다식으로 변경해보기
		IntPredicate test = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value % 2 ==0;
			}
		};// 이 식을 먼저 적어놓고  밑의 람다식으로 바꾸면된다.
		
		
		IntPredicate p = t -> t%2 ==0;
		IntStream.rangeClosed(1, 20)
		.filter(p)  //순차실행이므로 2의 배수중에서
		.forEach(s -> System.out.print( s+ " "));
		System.out.println();
	}

}
