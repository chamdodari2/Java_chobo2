package Java_chobo2.ch14.join;

import java.util.function.Function;

public class JoinFunctionEx {

	public static void main(String[] args) {
		int res = Integer.parseInt("AE", 16); // AE를 16진수로 바꾸면 1010 1110 (128+32+8+4+2)  ->> 결과 : 174 출력
		System.out.println(res);
		
		Function<String, Integer> fun = new Function<String, Integer>() {  //펑션쓰는법

			@Override
			public Integer apply(String t) {

				return Integer.parseInt(t, 16);
			}
		};
		System.out.println(fun.apply("AE"));  //결과 똑같이 174 나오는것을 확인할수있다.
		
		Function<String, Integer> f = s -> Integer.parseInt(s,16);//결과 똑같이 174 나오는것을 확인할수있다.
		System.out.println(f.apply("AE"));    
		
		Function<Integer, String> g = i -> Integer.toBinaryString(i);  //숫자가 들어가면 2진수로 바꾸고 , 그것을 문자열로 바꿔서 출력해주는것
		System.out.println(g.apply(174));  // 1010 1110 출력되는것을 확인할수있다.
		
		//andThen
		
		Function<String, String> h = f.andThen(g);    //위의 f, g를 적용한뒤 연쇄적(순차적)으로 실행하게된다.
		System.out.println(h.apply("AE"));  // 1010 1110 출력되는것을 확인할수있다
		
		
		//compose()   :   숫자를 집어넣으면 문자로 리턴하게 하기
		Function<Integer, String> j = i -> Integer.toBinaryString(i);
		System.out.println(j.apply(10)); //10을 넣으면 1010이 나오는것 확인가능
		Function<String, Integer> k = i -> Integer.parseInt(i,16);  //i를 16진수로 인식해서 리턴해라. 10을 16진수로 변환하는것
		System.out.println(k.apply("10"));
		
		//조합하기
		Function<Integer, Integer> l = k.compose(j); // j + k  -> l로 변환한다.  j를 먼저 적용후
		System.out.println(l.apply(10));  //10을 2진수로 변경해서 리턴해라   : 10을 넣으면 1010으로 변환되고-> 1*16^3 + 1*16 =  4112
	
	}

}
