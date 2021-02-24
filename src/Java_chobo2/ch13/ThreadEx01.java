package Java_chobo2.ch13;  //동시에 3개 수행되는것 확인

public class ThreadEx01 {  //

	public static void main(String[] args) throws InterruptedException {
		Threade01  th1 = new Threade01();
		th1.start();  //strat는 멀티스레드 동시동작 (교대로)
//		th1.run();   //이렇게 해야 Thread 다 수행후 순차적으로 수행된다.
		
		Thread02 runable = new Thread02();
		Thread th2 = new Thread(runable);   //이렇게 넣어줘야한다. Thread02는 Thread클래스를 상속받은게 아니기 때문에 
		th2.start();
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println("Done.");

	}

}
