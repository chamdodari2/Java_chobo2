package Java_chobo2.ch15;  //java.io.NotSerializableException  _> 구현이 안되어있따

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableEx {

	public static void main(String[] args) {
		String fileName = " UserInfo.ser"; // 직렬화해서 요 파일이름으로 붙일거다. 호가장자는 크게 의미없다 맞춰준다는 의미지
		try (FileOutputStream fos = new FileOutputStream(fileName);   //트라이캐치안에 리소스문 써서 클로즈 해줄필요없다.
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWoMan", "4321", 26);

			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);

			oos.writeObject(u1);
			oos.writeObject(u2);
			oos.writeObject(list);
			System.out.println("Done.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
