package Java_chobo2.ch14.stream;

import java.io.File;  //맵 : 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할때 사용하는것 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
//		extracted();
//		extracted02();
	
		//start 기본스트림을 스트림으로 변환
	IntStream intStream = new Random().ints(1,46);  //1~45사이의 정수 (46은 포함안된다)	
	Stream<Integer>	integerStream = intStream.boxed();  //기본타입을 스트림으로 변환할때 boxed가 필요  Int
	integerStream.limit(6).forEach(System.out::println);
	
	Stream<String> lottoStream =  new Random().ints(1,46).distinct().limit(6)
								.distinct().limit(6).sorted()
								.mapToObj(i -> i+",");   //IntStream => stream<String>
	lottoStream.forEach(System.out::print);  //12,14,20,23,26,29 처럼 출력된다
		
		//end 기본스트림을 스트림으로 변환 끝
		
	}//end of main

	public static void extracted02() {
		//start 스트림을 기본스트림으로 변환하기
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("이자바",3,300));
		list.add(new Student("김자바",1,200));
		list.add(new Student("안자바",2,100));
		list.add(new Student("박자바",2,150));
		list.add(new Student("소자바",1,200));
		list.add(new Student("나자바",3,290));
		list.add(new Student("감자바",3,180));
		
		Stream<Student> stdStream = list.stream();
//		Stream<Student> stdStream = Stream.of(   //이러면 소모되버려서 위에 다시 생성해주고 얘는 지움
//				new Student("이자바",3,300),
//				new Student("김자바",1,200),
//				new Student("안자바",2,100),
//				new Student("박자바",2,150),
//				new Student("소자바",1,200),
//				new Student("나자바",3,290),
//				new Student("감자바",3,180)
//				);
		
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalScore);   //점수만 출력해달라
	//	stdScoreStream.forEach(System.out::pintln);
		int total = stdScoreStream.reduce(0, (a,b) -> a+b);  //0부터 뭐를계산해라? a,b가 들어가게되면 a+b로 누적해라
		System.out.println(total);  //여기까지는 기본스트림 아님
				
		stdStream = list.stream();
		IntStream stdScoIntStream = stdStream.mapToInt(Student::getTotalScore);
		total = stdScoIntStream.max().getAsInt();  //최고점수 출력되는것 확인가능. 300
		System.out.println(total);
	
		//ent 스트림을 기본스트림으로 변환하기
	}

	public static void extracted() {
		List<File> list = new ArrayList<File>();
		list.add(new File ("Ex1.java"));
		list.add(new File ("Ex1.bak"));
		list.add(new File ("Ex2.java"));
		list.add(new File ("Ex1"));
		list.add(new File ("Ex1.txt"));
		
		//map()으로 Stream<File>를 Stream<String>으로 변환하기.
		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File::getName);
//		fileNameStream.forEach(System.out::println);
		//end  file이름이 나타나는것 확인가능.
		
		//start 확장자만 확인하기
		list.stream().map(File::getName)
		.filter(s->s.indexOf('.') != -1)    //.을 찾아서 -1이 아니면
		.map(s ->s.substring(s.indexOf('.')+1))
		.peek(s->System.out.printf("extends %s%n", s)) /////////////////////peek을 통해 중간연산결과 확인하기
		.map(String::toUpperCase)// 소문자를 대문자로 변경
		.peek(s->System.out.printf("upper %s%n", s)) /////////////////////peek을 통해 중간연산결과 확인하기 (출력된다)
		.distinct()
		.forEach(System.out::println);
		System.out.println();
		
		//end
		
		//start 스트림을 안쓴다면 반복문 써야한다.  그리고 distinct() 대신 set을 써서
		Set<String> s = new HashSet<>();
		for(File f : list) {  //반복문으로 리스트 하나씩 확인
			String ext = f.getName();
			
			if(ext.indexOf('.')!= -1) {  //이게 있고 -1 이 아니라면
			s.add( ext.substring(ext.indexOf('.')+1).toUpperCase());   //대문자로 변경
			}
				
//			s.add(f.getName());   /위에 두줄없이 여기까지하면 파일이름과 확장자 모두출력된다
			
		}
		System.out.println(s);
		
		//end
		//이해안되는 사람을 위해
		File file = new File ("test.java");
		String fileName = file.getName();   //"test.java"가 추출된다.
		int idx = fileName.indexOf(".") ;  //.을 찾기위해 indexof로 점 위치 찾음  -> 4
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx+1));  //suvstring은 시작위치부터 끝까지 출력하는기능임 .+1의 위치니까 확장자만 출력된다.
		//end 이해안되는 사람을 위한 설명
	}

}
