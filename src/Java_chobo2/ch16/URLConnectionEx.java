package Java_chobo2.ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionEx {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=018&aid=0004862582");

		try(BufferedReader br = new BufferedReader (
				new InputStreamReader(url.openStream()));
				
				BufferedWriter bw = new BufferedWriter(//콘솔창에서 보기 귀찮으니까 파일로 생성해서 보겠다
						new OutputStreamWriter(
								new FileOutputStream("test.html")))  
				){
			String line = null;
			
			while ((line = br.readLine()) != null) {  //한줄씩 읽어와서 라인에 담고 라인이 널이 아니라면 계속 보라
				System.out.println(line);
				bw.write(line);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
