package Java_chobo2.ch13;

class Thread05 extends Thread {
	@Override
	public void run() {
		while (!interrupted()) { // 발생했느냐. 발생하지 않았다면 수행할것 : 현재상태 반환 하고, false에서 true로 변경
			System.out.println("a");
		}
		System.out.println("end");
	}
}

public class ThreadEx08 {

	public static void main(String[] args) throws InterruptedException {
		Thread05 t = new Thread05();
		t.start();

		Thread.sleep(3000);
		t.interrupt();

	}

}
