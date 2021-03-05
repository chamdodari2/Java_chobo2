package Java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapEx {

	public static void main(String[] args) {
		
// start - flatMap 예제 교수님수정
		/*
		 * String[][] strArrs = { //2차원배열 {"abc","def","jkl"}, {"ABC","DEF","JKL"} };
		 * Stream<String[]> strArrStream = Stream.of(strArrs); Stream<Stream<String>>
		 * strStreamStream = strArrStream.map(Arrays::stream);
		 * strStreamStream.forEach(System.out::println);
		 * 
		 * Stream<String> strStream = strArrStream.flatMap(Arrays::stream);
		 * strStream.map(String::toLowerCase) .distinct() .sorted() .foreach()
		 */
			
//end- flatMap 예제 교수님수정 끝	
			
//start - 책예제 Ex14-7
			Stream<String[]> strArrStrm = Stream.of(
					new String[] {"abc","def","jkl"},
					new String[] {"ABC","DEF","JKL"}
					
					);
			Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
			
			strStrm.map(String::toLowerCase)  //왜 에러??
			.distinct()
			.sorted()
			.forEach(System.out::println);
			System.out.println();
			
			String[] lineArr = {
			"believe or not It is true",
			"Do or do not There is no try",					
			};
			
			Stream<String> lineStream = Arrays.stream(lineArr);
			lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);
			System.out.println();
			
		
					
//end - 책예제 Ex14-7
					
			
			
			

	}

}
