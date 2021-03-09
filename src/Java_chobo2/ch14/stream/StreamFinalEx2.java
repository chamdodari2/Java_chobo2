package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import sun.swing.text.CountingPrintable;

public class StreamFinalEx2 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));
		
		
		//스트림을 컬렉션으로 변환
//		extracted(list);
		
		//스트림의 통계정보
		extracted2(list);
		
		
	}

	public static void extracted2(List<Student> list) {
		//스트림의 통계정보
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.printf("count %d , %d%n",cnt1,cnt2);  //똑같이 7,7 뜬다
		
		//합계
		int sum1 = list
		.parallelStream()
		.mapToInt(Student::getTotalScore)
		.peek(System.out::println)
		.sum();  //Student에 있는함수 사용
		
		
		int sum2 = list
		.parallelStream()  //얘는 병렬수행
		.collect(Collectors.summingInt(Student::getTotalScore));
		System.out.printf("totalScore  %d , %d%n",sum1,sum2);
		
		//max
		OptionalInt max1 = list
		.parallelStream()
		.mapToInt(Student::getTotalScore)
		.peek(System.out::println)
		.max();  //Student에 있는함수 사용
		
		
		System.out.printf("maxScore %d%n",max1.getAsInt());
		
		//각각 학생의 점수를 비교해서 점수가 가장 높은 학생을 리턴
		Optional<Student> maxStd1 =
		list
		.parallelStream()
		.max(Comparator.comparingInt(Student::getTotalScore));
		Student std = maxStd1.get();
		System.out.println(std);
		
		//
		Optional<Student> maxStd2 = list.parallelStream()
				.collect(Collectors.maxBy(
						Comparator.comparingInt(Student::getTotalScore)));
		Student std1 = maxStd2.get();
		System.out.println(std1);
		//
		IntSummaryStatistics iss1 =  list
									.parallelStream()
									.mapToInt(Student::getTotalScore)
									.summaryStatistics();
		System.out.println(iss1);
		
		IntSummaryStatistics iss2 =  list
				.parallelStream()
				.collect(Collectors.summarizingInt(Student::getTotalScore));
		System.out.println(iss2);  //통계정보는 이게 더 편할거다
	}

	public static void extracted(List<Student> list) {
		// 스트림을 컬렉션으로 변환

//	Stream<Student> stuStream = list.stream().map
		List<String> stdList = list.stream().map(Student::getName).peek(System.out::println)
				.collect(Collectors.toList());
		System.out.println(stdList);

		ArrayList<Student> arList = list.stream().collect(Collectors.toCollection(ArrayList::new)); // 어레이리스트에 있는 뉴 ㅇㅇ
		System.out.println(arList);

		// Map <이름, 학생>
		Map<String, Student> map = list.stream().collect(Collectors.toMap(s -> s.getName(), s -> s));

		for (Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());

			
		}
	}
}
