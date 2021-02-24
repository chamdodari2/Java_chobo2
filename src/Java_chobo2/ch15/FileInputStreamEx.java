package Java_chobo2.ch15; //읽어들이기

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		fileInputStreamEx();
		File file = new File("mysql-connector-java-5.1.49 (1).jar");  //파일의 확장자  상관없이 다 복사가능하다.
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis, 1024);

				FileOutputStream fos = new FileOutputStream("mysql_lib.jar");
				BufferedOutputStream bos = new BufferedOutputStream(fos, 1024)) {
			int data = 0;
			while ((data = bis.read()) != -1) {
				bos.write(data);

			}
		}
	}

//		try(FileInputStream fis = new FileInputStream(file)) {

	public static void fileInputStreamEx() {
		try (FileInputStream fis = new FileInputStream("고양이.jpg");
				FileOutputStream fos = new FileOutputStream("test.jpg")) { // 이렇게 괄호안에 넣어주면 자동으로 close된다.

			int data = 0;
			while ((data = fis.read()) != -1) {
//				System.out.println((char)data);
				fos.write(data);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
