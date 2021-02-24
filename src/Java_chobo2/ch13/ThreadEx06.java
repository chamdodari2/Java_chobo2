package Java_chobo2.ch13;  //동시에 3개 수행될때 우선순위 

public class ThreadEx06 {  //

	public static void main(String[] args) throws InterruptedException {
		Threade01  th1 = new Threade01();
		System.out.println("우선순위 th1 "+ th1.getPriority());
		  //strat는 멀티스레드 동시동작 (교대로)

		
		Thread02 runable = new Thread02();
		Thread th2 = new Thread(runable);   //이렇게 넣어줘야한다. Thread02는 Thread클래스를 상속받은게 아니기 때문에 
		th2.setPriority(9);
		System.out.println("우선순위 th2 "+ th2.getPriority());
			
		th1.start();
		th2.start();
		
	

	}

}
