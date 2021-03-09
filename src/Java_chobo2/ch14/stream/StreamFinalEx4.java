package Java_chobo2.ch14.stream; //스트림의 요소를 2분할

import java.util.Arrays;

import java.util.Comparator.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class StreamFinalEx4 {

	public static void main(String[] args) {

//		new Student2(name,isMale,hak,ban,score)

		Student2[] stuArr = { new Student2("나자바", true, 1, 1, 300), new Student2("김지미", false, 1, 1, 250),
				new Student2("김자바", true, 1, 1, 200), new Student2("이지미", false, 1, 2, 150),
				new Student2("남자바", true, 1, 2, 100), new Student2("안지미", false, 1, 2, 50),
				new Student2("황지미", false, 1, 3, 100), new Student2("강지미", false, 1, 3, 150),
				new Student2("이자바", true, 1, 3, 200), new Student2("나자바", true, 2, 1, 300),
				new Student2("김지미", false, 2, 1, 250), new Student2("김자바", true, 2, 1, 200),
				new Student2("이지미", false, 2, 2, 150), new Student2("남자바", true, 2, 2, 100),
				new Student2("안지미", false, 2, 2, 50), new Student2("황지미", false, 2, 3, 100),
				new Student2("강지미", false, 2, 3, 150), new Student2("이자바", true, 2, 3, 200) };

		Map<Boolean, List<Student2>> stdBySex = Arrays.stream(stuArr)
				.collect(Collectors.partitioningBy(Student2::isMale)); // db과부화가 적어진다

		List<Student2> maleStds = stdBySex.get(true); // true인거만 가져와라
		System.out.println("남학생 = " + maleStds); // 남자만 다 나온다
		List<Student2> femaleStds = stdBySex.get(false); // 인거만 가져와라
		System.out.println("여학생 = " + femaleStds); // 여자만 다 나온다
		
		//분할+통계처리 (성별구분 + 각 성별 인원수 (count)까지 추가하기
		Map<Boolean, Long> stdNumBySex = Arrays.stream(stuArr)
				.collect(
						Collectors.partitioningBy(
								Student2::isMale,Collectors.counting()
						)
				); // 
		System.out.printf("남학생 수 %d, 여학생 수 %d%n",stdNumBySex.get(true),stdNumBySex.get(false));
		//남학생 수 8, 여학생 수 10
		
		
		Map<Boolean,Optional<Student2>> topScoreBySex = 
				Arrays.stream(stuArr)
				.collect(partitioningBy(
						Student2::isMale,
						maxBy(comparingInt(Student2::getScore))));
		System.out.println("남학생 1등 : " + topScoreBySex.get(true));
		System.out.println("여학생 1등 : " + topScoreBySex.get(false));
	///////// 7쪽	
		Map<Boolean, Object> topScoreBySex2 = 
		Arrays.stream(stuArr)
		.collect(
				partitioningBy(
						Student2::isMale,
				collectingAndThen(
						maxBy(comparing(Student2::getScore))
						,Optional::get
						)
				)
		);
		System.out.println("남학생 1등 : " + topScoreBySex2.get(true));
		System.out.println("여학생 1등 : " + topScoreBySex2.get(false));
		
		//성별로 분할수 성적으로 분할(점수 150점 기준)
		Map<Boolean, Map<Boolean, List<Student2>>> failedStdBySex =
				Arrays.stream(stuArr)
				.collect(partitioningBy(
						Student2::isMale,
						partitioningBy( s ->s.getScore()<150)
												
						)); // 
		
		List<Student2> failedMaleStu = failedStdBySex.get(true).get(true);
		List<Student2> failedfemaleStu = failedStdBySex.get(false).get(true);
		System.out.println("성별 불합격자 목록");
		System.out.println(failedMaleStu);
		System.out.println(failedfemaleStu);
		

	}

}
