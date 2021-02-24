package Java_chobo2.ch15;  // 657쪽 예제

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileEx {

	public static void main(String[] args) throws IOException {
//		File f = new File ("C:\\workspace_java\\native_jdbc_programing\\src\\native_jdbc_programing\\dto\\Department.java");
		File f = getSearchFile();
		
		String fileName = f.getName();
		System.out.println(fileName);  //파일이름만 출력된다.
		
		int idx = fileName.lastIndexOf(".");//뒤에서부터 검색
		
		System.out.println("경로를 제외한 파일이름 -"+f.getName());
		System.out.println("확장자를 제외한 파일이름 -"+fileName.substring(0,idx));
		System.out.println("확장자 -"+fileName.substring(idx+1));
		System.out.println();
		System.out.println("경로를 포함한 파일이름 -"+f.getPath());
		System.out.println("파일의 절대경로"+f.getAbsolutePath());
		System.out.println("파일의 정규경로"+f.getCanonicalPath());
		System.out.println("파일이 속해있는 디렉토리"+f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator -"+File.pathSeparator);
		System.out.println("File.paThSeparatorChar - "+File.pathSeparatorChar);
		System.out.println("FIle.separator - "+ File.separator);
		System.out.println("FIle.separatorChar - "+ File.separatorChar);
		System.out.println();
		System.out.println("user.dir = " + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path=" + System.getProperty("sun.boot.class.path"));
		
		//맨위의  f 경로각 ㅟ찮으니까 파일을 따로 만들거당

	}

	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));  //파일 검색기 . (실행되는경로) 찍어서 가져오기
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일뿐만 아니라 폴더도 선택할수있게 하기
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // 
		
		
		int res = jfc.showOpenDialog(null);
		File file = null;
		//재대로 선택되었다면
		if(res== JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());  //입력했던 경로가 쫙 나오게 한다
		}
//		System.out.println(res);
		return file;
		
	}

}
