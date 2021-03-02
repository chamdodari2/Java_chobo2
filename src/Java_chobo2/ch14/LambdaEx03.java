package Java_chobo2.ch14;

@FunctionalInterface  // --> 얘는 추상메소드 하나만 있는것을 정의하는 애
interface MyFunction{
		void myMethod();
}
public class LambdaEx03 {

	public static void main(String[] args) {
		//여기에 정의해줘야 밑에 전달할수있으니까네
		MyFunction f = () -> System.out.println("myMethod");// 이 식이 그대로 aMethod로 전달된다 이제 함수도 매개변수로 전달 가능하다.
		aMethod(f);
		
		// 
		aMethod(() -> System.out.println("myTwomethod()"));  //이렇게 바로 집어넣을수도 있다. 굳이 선언안하고!

	}

	
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}
}
