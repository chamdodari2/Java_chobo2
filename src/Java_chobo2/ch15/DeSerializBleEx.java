package Java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

//역직렬화 예제
public class DeSerializBleEx  {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = " UserInfo.ser";
		
		
		try(FileInputStream fis = new FileInputStream(fileName);
				
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)
				){
			
					/* 얘들도 주석해준다
					 * UserInfo u1 = (UserInfo) ois.readObject(); UserInfo u2 = (UserInfo)
					 * ois.readObject();
					 */
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) ois. readObject();
			
			System.out.println(list.get(0));
			System.out.println(list.get(1));
			/*
			 * System.out.println(u1); System.out.println(u2);
			 */
			System.out.println(list);
			
			System.out.println("done");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
