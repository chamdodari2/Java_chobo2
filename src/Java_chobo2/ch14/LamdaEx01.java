package Java_chobo2.ch14;

class LambdaInterClass implements LambdaInter {

	@Override
	public int max(int a, int b) {
		
		
		return 0;
	} // 클래스로 한다면

}

//메서드를 람다식으로 변환 실습 (객체생성을 해주어야함)
interface LambdaInter {
	public int max(int a, int b); // 인터페이스에 추상메서드 선언한 상태. 야ㅒ도 사실은 자동으로 추가되어서 이 한줄 필요없다??

}

interface LambdaInter1 {
	void printVar(String name, int i);
}

interface LambdaInter2 { // 2교시 실습 1 람다식
	int square(int x);

}

interface LambdaInter3 { // 2교시 실습 2 람다식
	int roll();
}
interface LambdaInter4 { // 2교시 실습 2 람다식
	int sumArr(int[] arr ) ;  //배열의 누적합을 반환하는 메소드. 한문장이 아니어서 다적어야함
	
}

public class LamdaEx01 {

	public static void main(String[] args) {
		LamdaEx01 ex = new LamdaEx01(); // 여기에

		/*
		 * int a = ex.max(5,3); System.out.println("max = " + a);
		 */

		LambdaInterClass lic = new LambdaInterClass();
		int c = lic.max(5, 4);
		System.out.println("max = " + c);
		
		LambdaInter lbi0 = new LambdaInter() { //클래스를 따로 선언하지 않고도 이렇게 정의가능 익명으로
			
			@Override
			public int max(int a, int b) {			
				return a > b ? a: b;
			}
		};
		System.out.println( "max = " +lbi0.max(1, 3));

		LambdaInter lbi = (i, j) -> i > j ? i : j; // 위의 인터페이스를 람다식으로 구현한것. (a,b는 i,j로 바꿔서 ? 선언한것 )
		int b = lbi.max(5, 3);
		System.out.println("max = " + b);

		LambdaInter1 lbi1 = (String name, int i) -> {
			System.out.println(name + " : " + i);
		}; // 이렇게 해줄수 있다. 교재 554
		lbi1.printVar("김상건", 5); // 첫번째

		LambdaInter1 lbi2 = (name, i) -> {
			System.out.println(name + " : " + i);
		}; // . 교재 554
		lbi2.printVar("이나연", 15); // 두번쨰. 타입 빼기

		LambdaInter1 lbi3 = (name, i) -> System.out.println(name + " : " + i); // 교재 554
		lbi3.printVar("신범건", 25); // 세번쨰. 중괄호 빼기
		// 스퀘어
		LambdaInter2 lbi4 = (int x) -> x * x;
		LambdaInter2 lbi5 = x -> x * x; // 타입,괄호 생략가능
		System.out.println("square : " + lbi4.square(5));
		System.out.println("square : " + lbi5.square(5));

		LambdaInter3 lbi6 = () -> {
			return (int) (Math.random() * 6);
		};
		LambdaInter3 lbi7 = () -> (int) (Math.random() * 6); // 타입, 중괄호 생략가능. 매개변수 없이 임의의 값 반환하기
		System.out.println("random : " + lbi6.roll());
		System.out.println("random : " + lbi7.roll());
		
		LambdaInter4 lbi8 = (int[] arr) -> {  //누적값 반환하기
			 int sum = 0;
			 for(int i : arr) sum += i;
			 return sum;
		};
		System.out.println(lbi8.sumArr(new int[] {1,2,3,4,5,6,7,8,9,10}));
	}

	/*
	 * public int max(int i, int j) { // 얘는 종속적이다. 의미없음. return i > j ? i : j; }
	 */

}
