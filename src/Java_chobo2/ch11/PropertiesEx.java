package Java_chobo2.ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesEx {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("url", " jdbc:mysql://localhost:3306/mysql_study?useSSL=false");
		
		prop.setProperty("user", "user_mysql_study");
		prop.setProperty("password", "rootroot");
		
		//위 내용을 파일로 저장하기
		try {
			prop.store(new FileOutputStream("oupt.txt"),"properties Example");  //세번쨰 트라이캣치로 묶기
			//이걸로도 해보기 -FileWriter
			prop.store(new FileWriter("oupt2.properties"),"properties Example");  //세번쨰 트라이캣치로 묶기
			//이걸로도 해보기2 -xml
			prop.storeToXML(new FileOutputStream("oupt.xml"), "properties Example XML","UTF-8" );
			//후, XML 에디터로 열기 해서 소스보기하면 볼수있당.
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}   
		//파일로부터 읽어오기(load)
		Properties loadProp = new Properties();  //트라이캐치하기
		//xml로도 읽어와보기
		Properties xmlProp = new Properties();  //트라이캐치하기
		try {
			loadProp.load(new FileInputStream("oupt.txt"));
				prnProperties(loadProp);
				
				xmlProp.loadFromXML(new FileInputStream("oupt.xml"));
				prnProperties(xmlProp);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	private static void prnProperties(Properties loadProp) {
		Set<Object> keys = loadProp.keySet();
		for(Object key : keys) {
			System.out.println(key + " : " +loadProp.getProperty((String)key));
		}
		
	}

}
