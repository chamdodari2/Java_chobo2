package Java_chobo2.ch13;

public class Thread03 implements Runnable {
	static boolean autoSave = false;
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(autoSave) {
				autoSave();
			}
		}

	}
	private void autoSave() {
		System.out.println("작업 파일이 자동저장되었습니다.");  //역할: 3초있다가 autoSave가 true면  저장, 아니라면
		
	}

}
