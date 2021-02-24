package Java_chobo2.ch15;  //마저해야한다

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteArrayInputStreamEx {

	public static void main(String[] args) {
		//예제?
//		출력 바로 보내는게 아니라 임시공간(임시버퍼)인 Array에 집어넣고, 그다음 실제 공간 outSrc에 넣어서 보내준다.
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };   // byte라서 숫자 0부터 127까지 넣을수 있다.
		byte[] outSrc = null;
		
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);  //입력값을 입력임시공간에 넣기
		ByteArrayOutputStream baos= new ByteArrayOutputStream();		//출력임시공간 만들기
		int data = 0;	//초기화
		while( (data = bais.read()) != -1) {  //0을 하나 읽어와서 데이터에 담고, -1이 아니라는 것은 아직 끝이 아니라는 것이기 때문에 끝까지 담을수 있다. (read :  end of the stream has been reached, the value -1 is returned)
		baos.write(data);	  //읽어와서   출력임시저장공간에 쓰기	
		}
		outSrc = baos.toByteArray();  // 출력임시저장공간에 있던것을 출력할곳에 집어넣는다
		System.out.println("Input Source : "+ Arrays.toString(inSrc));
		System.out.println("Output Source : "+ Arrays.toString(outSrc));

	}

}
