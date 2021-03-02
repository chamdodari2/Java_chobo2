package Java_chobo2.ch14;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaEx02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa"); // 점이세개
		// abc 순으로(사전순) 정렬해보기
		System.out.println("정렬전 " + list);

		// fm대로해보기
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		Collections.sort(list, comp); // 위에있는 comp를 기준으로 정렬해달라
		System.out.println("정렬후 " + list);

		// 한줄로 끝내기
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2)); // 이렇게 하면 한줄에 끝난다. 리턴되는게 일로 들어온다
		System.out.println("한줄로 끝낸 정렬후" + list);
	}

}
