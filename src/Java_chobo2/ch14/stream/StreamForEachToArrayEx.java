package Java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamForEachToArrayEx {

	public static void main(String[] args) { // 스트림의 최종연산. ForEach(), forEachOrdered()

		IntStream.range(1, 10).sequential().forEach(new IntConsumer() { // 각각 1부터 던져주면 어떻게 처리할건가 -> 억셉트메소드가 호출된다

			@Override
			public void accept(int value) {
				System.out.print(value);

			}
		});
		System.out.println();  //정렬되어 123456789로 출력된다
		
		//람다식변경
		IntStream.range(1, 10).forEach(System.out::print); //바로참조하라는 이야기  -> 메소드 참조하는 방법임 int balue를 바로 정의하면 되는것
		IntStream.range(1, 10).forEach(e -> System.out.print(e)); //예시추가
		System.out.println();  //결과가 똑같이 나오는것 확인가능
		
		//람다식2
		IntStream.range(1, 10).parallel().forEach(System.out::print);   //parallel이 정렬한뒤에 forEach가 묶을때 순서를 보장안해버림
		System.out.println();    //657892431로 나온다. 결과 같지않음
		
		//람다3
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print);// parallel()을 쓸때는 forEachOrdered를 쓰면 순서를 보장해준다 123456789로 나옴
		System.out.println();
		
		
		//스트링을 배열로 변환하기 예제 - 스트링을 배열로 먼저 생성하기
		Student[] stdArr = {new Student("김인환", 1, 280),
							new Student("이태훈",1,270),
							new Student("김상건",2,260),
							new Student("전수린",2,250),
							};
		Stream<Student> studentStream = Arrays.stream(stdArr);
		
		////위에까지 클래스가 다르다면 스트림으로 넘겨줄수밖에 없다??     //투어레이하기
		Student[] tempArr = studentStream.toArray(Student[]::new);
		System.out.println(Arrays.toString(tempArr));
		System.out.println();
		//
		studentStream =  Arrays.stream(stdArr);
		Object[] objArr = studentStream.toArray();
		System.out.println(Arrays.toString(objArr));
		
		
	}

}
