package Java_chobo2.ch14;

import java.util.function.Predicate;

public class FunctionPredicateEx {

	public static void main(String[] args) {
		String[] strArr = { "", "ab", "", "abc", "def","" };

		// 공백인거 제외시키기
		Predicate<String> isEmptyStr = s -> s.length() == 0; // 매개변수가 하나, 리턴타입도 하나니까 생략가능하다.
		int cnt = 0;
		for (String str : strArr) {
			if (isEmptyStr.test(str)){// 0과 같으면 던져쥬
				cnt += 1;
			}
		}
		System.out.println("공백 문자열의 개수 : "  + cnt);

	}

}
