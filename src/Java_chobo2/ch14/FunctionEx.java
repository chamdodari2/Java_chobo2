package Java_chobo2.ch14;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionEx {

	public static void main(String[] args) {
		Supplier<Integer> f = () -> (int) (Math.random() * 100) + 1; // 랜덤값 구하기
		System.out.println(f.get());
///////////////////////////////////////////////////////////////////////////////
		Supplier<Integer> f01 = new Supplier<Integer>() { // 이렇게 해도 된다. 한줄쓰
			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1; // 1에서 10 사이의 수
			}
		};
		System.out.println(f01.get());
////////////////////////////////////////////////////////////////////////////////////////
		// 이너클래스로 정의해보기 . 이렇게 할필요는 사실 없다
		class MySupplier implements Supplier<Integer> {
			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1;
			}
		};
		MySupplier ms = new MySupplier();
		System.out.println(ms.get());
 ////////////////////////////////////////////////////////////////////////////////////////
		Consumer<Integer> f1 = i -> System.out.println(i + ","); // i를 넘겨주면 i를 출력쓰 밑에꺼 먼저 만들어봐야 이게 나온다.
		f1.accept(10);
		
		//
		
		Consumer<Integer> f101 = new Consumer<Integer>() {  //처음에는 이렇게 만들어놓고 위와같이 변환하면된다.
			@Override
			public void accept(Integer t) {
				System.out.println(t+",");
				
			}
			
		};
		Predicate<Integer> f2 = i -> i % 2 == 0; // i가 들어갔을떄 2의 배수와 같으면 (나눳을떄 나머지가 0이므로)
		System.out.println(f2.test(3) + "," + f2.test(4));
		
		Predicate<Integer> f201 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {	  //t를 2로 나눈값이 0과 같으면 트루 반환	
				return t % 2 == 0;
			}
		};
		System.out.println(f201.test(3) + "," + f201.test(4));
		Function<Integer, Integer> f3 = i -> i / 10 * 10; // 10을 넣으면 10이 리턴되도록 한다. i는 매개변수타입을 의ㅣ
		System.out.println(f3.apply(20));
		
		Function<Integer, Integer> f301 = new Function<Integer, Integer>() {		
			@Override
			public Integer apply(Integer t) {
				return t*t; //제곱을 반환해라
			}
		};
		System.out.println(f301.apply(5));
	}

}
