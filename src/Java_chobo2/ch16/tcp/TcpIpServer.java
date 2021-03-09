package Java_chobo2.ch16.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7777);
			System.out.printf("%tF 서버가 준비되었습니다.%n", new Date());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true) {  //항상 대기하고있어야해서 무한루프돈다
			System.out.printf("%tF 요청을 기다립니다.%n", new Date());
			
			try {
				Socket socket = ss.accept();
				System.out.printf(
						"%tF %s 로부터 연결 요청이 들어왔습니다.", 
						new Date(), 
						socket.getInetAddress());
				
				//IO스트림 생성중 out스트림 생성만  
//				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				//requst한 클라이언트에게 전달
				
				dos.writeUTF("[Notice] Test Message1 from Server");  //클라이언트에게 보내는거
				System.out.printf("%tF 데이터를 전송했습니다.%n",new Date());
				
				dos.close();
				socket.close();  //닫아주기
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
