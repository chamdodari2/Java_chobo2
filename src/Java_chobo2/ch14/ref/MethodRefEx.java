package Java_chobo2.ch14.ref;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sun.org.apache.xpath.internal.FoundIndex;
class MyClass {
	int x;
	int y;

	public MyClass() {
	}

	public MyClass(int x) {
		this.x = x;
	}

	public MyClass(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MyClass) {
			MyClass other = (MyClass) obj;
			if (x == other.x) {
				return true;
			}
		}
		return false;

	}// end of equals

	@Override
	public String toString() {
		return String.format("MyClass [x=%s, y=%s]", x, y);
	}

}// end of MyClass
public class MethodRefEx {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("16")); // 16이 출력되는것을 확인가능

		// 람다식으로 간략하게 한줄로 바꾸기
		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f2.apply("16")); // 똑같이 16이 출력되는것을 확인가능

		// 매개변수 두개 비교하기
		BiFunction<String, String, Boolean> g = (s1, s2) -> s1.equals(s2); // 두개의 문자열을 비교해서0
		System.out.println(g.apply("abc", "abc")); // 각 매개변수에 문자열 집어넣기

		// 람다식으로 간략하게 한줄로 바꾸기
		BiFunction<String, String, Boolean> h = String::equals;
		System.out.println(h.apply("abc", "abc")); // 각 매개변수에 문자열 집어넣기

		// 특정 객체의 인스턴스 메서드 참조하는방법 (비교)
		

		MyClass m1 = new MyClass(5, 2);
		MyClass m2 = new MyClass(4, 3);
		MyClass m3 = new MyClass(5, 3);

		Function<MyClass, Boolean> j = i -> m1.equals(i);
		System.out.println(j.apply(m2)); // false 출력되는것 확인가능
		System.out.println(j.apply(m3)); // true 출력되는것 확인가능

		// 매서드참조로 바꾸면
		Function<MyClass, Boolean> k = m1::equals;
		System.out.println(k.apply(m2));
		System.out.println(k.apply(m3));
		
		
		//new 연산자(생성자,배열)와 메서드 참조"?
		
		Supplier<MyClass> s = MyClass::new; // //default constructor
		System.out.println(s.get());  //0이 출력되는것 확인가능
		
		Function<Integer, MyClass> t = MyClass::new;    //MyClass(in)
		System.out.println(t.apply(10));
		
		//MyClass(int,int) 해보기  매개변수가 두개면 Bi 써야함
		BiFunction<Integer, Integer, MyClass> u = MyClass::new;
		System.out.println(u.apply(5,6));
		
		//array 해보기
		Function<Integer, int[]> v = int[]::new;
		System.out.println(Arrays.toString(v.apply(5)));   //5개의 배열이 생성되는것을 확인할수있다.

	} // main

}
