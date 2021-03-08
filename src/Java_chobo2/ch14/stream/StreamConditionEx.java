package Java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConditionEx {
	//조건검사  anyMatch(),/anyMatch(), 조건에 일치하는 요소 찾기 
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",1,200));
		list.add(new Student("안자바",2,100));
		list.add(new Student("박자바",2,150));
		list.add(new Student("소자바",1,95));
		list.add(new Student("나자바",3,290));
		list.add(new Student("감자바",3,80));
		
		matchEx(list); //anyMatch()
		find(list);
		
	}
	
	
//findFirst() filter하기
private static void find(List<Student> list) {
	Stream<Student> stdStream = list.stream();
	Optional<Student> result = stdStream.filter(s->s.getTotalScore()<= 100).findFirst(); //점수가 100이하인 사람을 찾아서 첫번쨰 사람
	System.out.println(result);
//end
	
	//findAny(),parallelStream().filte
	result =  list.parallelStream().filter(s-> s.getTotalScore() <= 100).findAny();  //100보다 작은사람 병렬
	System.out.println(result); //임의의 한사람이 출력된다
	}
//end

//anyMatch()
	private static void matchEx(List<Student> list) { //list를 String으로 바꾸면된다
		Stream<Student> stdStream = list.stream();
		
		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {  
				
				return t.getTotalScore() <= 100; // 한명씩 꺼내와서 100보다 작으면 true를 던져달라
			}
		});
		System.out.printf("hasRes => %s%n",hasRes);  // 결과 : hasRes => true
//end		
		
////allMatch()		
		stdStream = list.stream();
		hasRes = stdStream.allMatch(s ->s.getTotalScore()>= 80);  //모두다 80 이상이면 true를 출력해달라
		System.out.printf("getTotalScore >= 80 : %s%n", hasRes);
	}

}
