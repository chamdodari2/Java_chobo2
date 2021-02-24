package Java_chobo2.ch15;  //폴더와 파일 구분하여 목록 출력하기

import java.io.File;

import javax.swing.JFileChooser;

public class FileEx2 {

	public static void main(String[] args) {
		File f = getSearchFile();
		System.out.println(f.getName());
		
		if(!f.exists()|| !f.isDirectory()) {//선택한게 디렉토리가 아니면 
			System.err.println("유효하지 않은 디렉터리입니다. ");
			System.exit(0);
		}		
		//하위 파일의 목록 가져오기
		File[] files = f.listFiles();
//		System.out.println(files);
		for(File file : files) {
			System.out.println(file.isDirectory() ?"["+ file.getName() + "]" : file.getName()); //디렉토리랑 같니? 디렉토리면 []안에 이름 찍어주기. 아니면 그냥 이름만 찍어주기
		}
	}
	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));  //파일 검색기 . (실행되는경로) 찍어서 가져오기
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일뿐만 아니라 폴더도 선택할수있게 하기

				
		int res = jfc.showOpenDialog(null);
		File file = null;
		//재대로 선택되었다면
		if(res== JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
//			System.out.println(file.getAbsolutePath());  //입력했던 경로가 쫙 나오게 한다
		}
//		System.out.println(res);
		return file;
		
	}
}

