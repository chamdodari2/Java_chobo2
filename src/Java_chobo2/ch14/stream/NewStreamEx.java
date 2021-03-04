package Java_chobo2.ch14.stream;

import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class NewStreamEx {

	public static void main(String[] args) {
		//특정범위의 정수를 요소로 갖는 스트림 생성하기
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(1, 10).forEach(System.out::print);
		
		System.out.println();
		//난수를 요소로 갖는 스트림 생성하기]
		new Random(1234).ints().limit(5).sorted().forEach(System.out::println);  // ::는 메소드참조를 뜻함
		System.out.println();	
		//
		System.out.printf("ints() range => %d~%d%n",Integer.MIN_VALUE,Integer.MAX_VALUE);
		//위에꺼 한줄로 줄인거. api활용
		new Random(1234).ints(5).sorted().forEach(System.out::println);
		System.out.println();  
		//결과를 가져오고싶으면
		
		new Random(1234).ints().limit(5).sorted();
	}

}
