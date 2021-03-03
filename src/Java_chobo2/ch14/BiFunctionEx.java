package Java_chobo2.ch14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionEx {

	public static void main(String[] args) {

		// 매개변수 두개있는거. 람다식 전에 그냥해보기
		BiConsumer<String, Integer> bic = new BiConsumer<String, Integer>() { // 이//이 스트링이 뒤의 인티저와 길이가 같으면!
			@Override
			public void accept(String t, Integer u) {
				if (t.length() == u) {
					System.out.println("같음");
				} else {
					System.out.println("다름");
				}

			}
		};
		bic.accept("abc", 2);
		bic.accept("abc", 3);
		////////////////////////////////////// 람다식으로 바꾸어보시오. 삼항연산자는 안된다

//		String str ="abc".length() ==3 ? "같음" : "다름"; 
		BiConsumer<String, Integer> bic01 = (t, u) -> {
			if (t.length() == u) {
				System.out.println("같음");
			} else {
				System.out.println("다름");
			
			}
			};
		
			// String str = "abc".length() ==3 ? "같음" :"다름";
			bic01.accept("abc", 2);
			bic01.accept("abc", 3);
///////////////////////////////////////////////////
			BiPredicate<String, String> bip = new BiPredicate<String, String>() {
				@Override
				public boolean test(String t, String u) {
					return t.equals(u);
				}
			};
			System.out.println(bip.test("abc", "ab"));
			System.out.println(bip.test("abc", "abc"));
//////////////////////////////////////////////////////////
			BiPredicate<String, String> bip01 = (t, u) -> t.equals(u);
			System.out.println(bip01.test("abc", "ab"));
			System.out.println(bip01.test("abc", "abc"));

			BiFunction<Integer, Integer, String> bif = new BiFunction<Integer, Integer, String>() {
				@Override
				public String apply(Integer t, Integer u) {
					if (t == u) {
						return "true";
					} else {
						return "false";
					}
				}

			};// 람다식으로 해보시오
			System.out.println(bif.apply(5, 7));
			System.out.println(bif.apply(7, 7));

			BiFunction<Integer, Integer, String> bif01 = (a, b) -> a == b ? "true" : "false";
			System.out.println(bif01.apply(5, 7));
			System.out.println(bif01.apply(7, 7));
		} 
		
		
		
}

