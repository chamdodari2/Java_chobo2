package Java_chobo2.ch14;

@FunctionalInterface
interface MyFunction2 {
	void run();
}

public class Ex14_1 {

	static void execute(MyFunction2 f) { //매개변수 타입이 MyFunction인 메소드
		f.run();
	}

	static MyFunction2 getMyFunction() {  //반환타입이 MyFunction인 메서드
		MyFunction2 f = () -> System.out.println("f3.run()");
		return f;
	}

	public static void main(String[] args) {
		//람다식으로 MyFunction 의 run을 구현
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() {		
			@Override
			public void run() {
				System.out.println("f2.run()");
				
			}
		};
		MyFunction2 f3 =getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute(() -> System.out.println("run()"));
		
		
	}

}
