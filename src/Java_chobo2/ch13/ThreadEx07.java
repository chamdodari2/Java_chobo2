package Java_chobo2.ch13;  // 데몬을 이용하여수행시킨 곳에서 종료가 되면 03도 따라서 종료가 되도록 하는것. 없으면 무한반복된다.

public class ThreadEx07 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Thread03());
		t1.setDaemon(true);
		t1.start();

		for (int i = 1; i < 11; i++) {

			Thread.sleep(1000);
			System.out.println(i);

			if (i == 5) {
				Thread03.autoSave = true;

			}
			
		}
		System.out.println("프로그램 종료");
	}
}