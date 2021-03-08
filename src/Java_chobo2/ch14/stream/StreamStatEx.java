package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamStatEx {
///스트림에 대한 통계정보 제공. count(), sum(), average(),max(),min()
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",1,200));
		list.add(new Student("안자바",2,100));
		list.add(new Student("박자바",2,150));
		list.add(new Student("소자바",1,95));
		list.add(new Student("나자바",3,290));
		list.add(new Student("감자바",3,80));
//count()
		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		long cnt1 = list.stream().count();
		long cnt2 = intList.stream().count();
		System.out.printf("list cnt = %d, intList cnt = %d%n", cnt1,cnt2);
		
//max() 최고점인 학생정보 출력하기
		Optional<Student> optStd =	list.stream().max(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getTotalScore() - o2.getTotalScore();
			}
		});
		System.out.println("max Total Score Student " + optStd);  //이자바가 나온다
		System.out.println();
		//람다식으로 바꿔보기
		Optional<Student> optStd2 =	list.stream().min((o1,o2) -> o1.getTotalScore()-o2.getTotalScore());
		System.out.println("max Student " + optStd );
		System.out.println("min Student " + optStd2 );
		//람다2
		Optional<Student> optStd3 =  list.parallelStream().min((o1,o2)->o1.getTotalScore()-o2.getTotalScore());
		System.out.println("parallelStream min Student " + optStd3 );
		
		//람다3
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		IntStream intStream = IntStream.of(arr);
		int sum = intStream.sum();		
		OptionalDouble avg = IntStream.of(arr).average();  //여기가 문젠가본디  이유 :: 앞에서 사용했기때문에 새로 생성하거나 IntStream.of(arr)붙여줘야쓸수있다.
		OptionalInt  max = IntStream.of(arr).max();
		OptionalInt  min = IntStream.of(arr).min();
		
		System.out.printf("sum = %d, avg = %.2f, max = %d, min = %d%n", 
							sum,avg.getAsDouble(),max.getAsInt(),min.getAsInt());  //옵셔널 더블이어서 그냥avg쓰면안되고 겟해야함 min도 마찬가지
		
		IntSummaryStatistics summary = IntStream.of(arr).summaryStatistics();
		System.out.println(summary);
		System.out.printf("count = %d, sum = %d, avg = %.2f, max =%d, min = %d%n",
				summary.getCount(),
				summary.getSum(),
				summary.getAverage(),
				summary.getMax(),
				summary.getMin());
	
	}

	

}
