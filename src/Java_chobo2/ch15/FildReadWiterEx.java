package Java_chobo2.ch15; //문자 기반 스트림 - Reader 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FildReadWiterEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		fileReadWriterEx();
//버퍼도 써보자/ 동시에 두개하기 따로 안하고
		
		try(FileReader fr = new FileReader("oupt2.properties");// 이 파일을 읽어서
				BufferedReader br = new BufferedReader(fr,8192);  //input이면 input read면 read를 써야한다
				
				FileWriter fw = new FileWriter("test.properties");  //이 이름으로 복제한다
				BufferedWriter bw = new BufferedWriter(fw,8192))
		 		
				{
			String line;
			while ((line = br.readLine()) !=null) {
				bw.write(line);
				bw.newLine();
			}
			
		}

	}

	public static void fileReadWriterEx() {
		try (FileReader fr = new FileReader("oupt.xml");   //이 파일에서 읽어서
				FileWriter fw = new FileWriter("test.xml")) {  //이 이름으로 복제한다
			
			char[] cbuf =  new char[512];  //단위로 (512개씩)  읽어들이는것. 앞에 했던건 1개씩 읽었기때문에 이게 더 빠르다
			while((	fr.read(cbuf)) !=-1) { //읽어들여서 그 값이 -1이 아니면 읽어들인 내용응 아래에 담는다
				fw.write(cbuf);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("해당 파일이 존재하지 않음.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
