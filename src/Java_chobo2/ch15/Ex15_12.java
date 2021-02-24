package Java_chobo2.ch15; //InputStreamReder, OutputSrteamWriter

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15_12 {

	public static void main(String[] args) {
		String line = " ";
		try {
			//운영체제에서 사용하는 기본 인코딩의 문자로 변환하는  isr 생성
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("사용 중인 OS 의 인코딩 : " + isr.getEncoding());
			do {
				System.out.println("문장을 입력하세요. 마치시려면 Q를 입력하세요. > ");
				line = br.readLine();
				System.out.println("입력하신 문장 : " + line);
			} while (!line.equalsIgnoreCase("q"));
			System.out.println("프로그램을 종료합니다");

		} catch (IOException e) {

		}
	}

}
