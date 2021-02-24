package Java_chobo2.ch13;  //2를 쓰레드로 바꾸기

class Thread04 extends Thread{
	@Override
	public void run() {
		
		for(int i = 0; i <300; i++) {
			System.out.printf("%s", "|");
		}
		System.out.println();
		System.out.printf("%s %d 나노초%n", "두번째 작업", System.currentTimeMillis() - startTime);
		
	}
	}

public class ThreadEx3 {
	static long startTime = 0;
	public static void main(String[] args) {
		Thread04 thread = new Thread04();
		thread.start();
		
		ThreadEx3.startTime =  System.currentTimeMillis();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", ("-"));
		}

		System.out.println();
		System.out.printf("%s %d 나노초%n", "첫번째 작업", System.currentTimeMillis() - startTime);
		for(int i = 0; i <300; i++) {
			System.out.printf("%s", "|");
		}
		/*
		 * System.out.println(); System.out.printf("%s %d 나노초%n", "두번째 작업",
		 * System.currentTimeMillis() - startTime);
		 */
		
	}

}
