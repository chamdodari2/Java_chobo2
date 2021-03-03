package Java_chobo2.ch14.join;

import java.util.function.Predicate;

public class JoinPredicateEx {

	public static void main(String[] args) {
		extracted01();
	}

	public static void extracted01() {
		Predicate<Integer> p1 = new Predicate<Integer>() { // 람다식이 되면 new Predicate<Integer>() 빠진다

			@Override
			public boolean test(Integer t) {

				return t > 100; // 넘어온값이 100보다 작으면 트루다. 람다식이 되면 매개변수명을 i로 바꾸고 식은 그대로 쓰면 된다.
			}
		};
		Predicate<Integer> p = i -> i < 100;   //매개변수 i가 100보다 작다면  p는 트루
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		
		Predicate<Integer> notP = p.negate();  //p의 식 결과를 반대로 출력한다
		
		System.out.println(p.test(101) + " : " + p.test(99));
		System.out.println(notP.test(101) + " : " + notP.test(99));
		Predicate<Integer> all = notP.and(q).or(r); //100보다 크거나 같고, 200보다 작거나 짝수이면 트루
		//( i >= 100 && i < 200 )|| (i%2 ==0)  
		
		System.out.println(all.test(201) + " : " + all.test(101) + " : " + all.test(98));  
		Predicate<Integer> all2 = notP.and(q.or(r));
		//i >= 100&& (i<200|| i%2 ==0) 매개변수가 100보다 작고, 200보다 작거나 짝수이면 트루
		System.out.println(all2.test(201) + " : " + all2.test(101) + " : " + all2.test(98));  
		
		String str1 = "abc";
		String str2 = "abc";
		Predicate<String> pEq = Predicate.isEqual(str1);     //문자열 동일한지 비교
		boolean result = pEq.test(str2);
		System.out.println(result);
		
		//한줄로 적는방법		
		result = Predicate.isEqual(str1).test(str2);  //
	}

}
