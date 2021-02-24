package Java_chobo2.ch13;// i/o 블락킹  : 입력하기 전까지는 수행할수없더라

import javax.swing.JOptionPane;

public class ThreadEx04 {

	public static void main(String[] args) throws InterruptedException {
	String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
	System.out.println("입력한 값은 " +  input + "입니다.");
	for(int i = 10; i>0; i--) {
		System.out.println(i);
		Thread.sleep(1000);
	}
	}

}
