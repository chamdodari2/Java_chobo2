package Java_chobo2.ch11;  //HashMap으로 작성해보기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class StudentManagement3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Student[] students = new Student[5];
		HashMap<Integer, Student> students = new HashMap<>();
		initial(students);		

		System.out.println("학생관리 프로그램");
		int choice;
		do {
			showMenu();
			System.out.print("메뉴 > ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("학생 추가");
				addStudent(students, sc);
				break;
			case 2:
				System.out.println("학생 수정");
				modifyStudent(students, sc);
				break;
			case 3:
				System.out.println("학생 삭제");
			//	students = deleteStudent(students, sc);
				break;
			case 4:
				System.out.println("학생 목록");
				prnStudent(students);
				break;
			}
		} while (choice < 5);
		sc.close();  //여기까지무시
	}
	private static void deleteStudent(HashMap<Integer, Student> students, Scanner sc) {
		prnStudent(students);
		System.out.println("삭제하고자하는 학생번호 입력 >");
		int delStdNo = sc.nextInt();
		
		Student delStudent = new Student(delStdNo);
		if (!students.containsKey(delStudent)) {  //
			System.out.println("해당 하는 학생이 존재하지 않음");
		}
		
		students.remove(delStudent);		
	}

	private static void modifyStudent(HashMap<Integer, Student> students, Scanner sc) {
		// 1. 학생번호 입력
		// 2. 해당 위치에 입력받은 학생정보를 변경
		prnStudent(students);
		System.out.println("수정하고자하는 학생번호 입력 >");
		int findStdNo = sc.nextInt();
		
		Student upStd = new Student(findStdNo);
		
		
		
		if (!students.containsKey(upStd)) {
			System.out.println("해당 하는 학생이 존재하지 않음");
			return;
		}
		int idxStdNo = students.indexOf(upStd);
		students.set(idxStdNo,createStudent(sc));
	}
		
	


	private static void addStudent(HashMap<Integer, Student> students, Scanner sc) {
		// 1. 저장된 학생수 입력 or 종료
		// 2. 추가할 위치를 검색
		// 3. 추가할 학생정보를 입력

			Student newStd = createStudent(sc);
		if (students.containsKey(newStd)) {
			System.out.println("동일한 학생을 입력할 수 없습니다.");
			return;
		}
	
		students.add(newStd);
		
	}

	private static Student createStudent(Scanner sc) {
		System.out.println("학생 정보를 입력하세요. ex) 번호 성명 국어 영어 수학");
		int stdNo = sc.nextInt();
		String name = sc.next();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		return new Student(stdNo, name, kor, eng, math);
	}

	private static int findIdx(Student[] students) {
		for(int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				return i;
			} 
		}
		return -1;
	}

	private static void prnStudent(HashMap<Integer, Student> students) {
		for (Student std : students) {			
			System.out.println(std);
		}
		System.out.println();
	}

	private static void initial(HashMap<Integer, Student> students) {  //ArrayList<Student> students
		students.put(1, new Student(1, "전수린", 90, 90, 90));
		students.add(new Student(2, "김상건", 91, 91, 91));
		students.add(new Student(3, "이태훈", 92, 92, 92));
	}

	private static void showMenu() {
		String[] m = new String[6];
		m[0] = "메뉴를 선택하새요.\n";
		m[1] = "1. 학생 추가\n";
		m[2] = "2. 학생 수정\n";
		m[3] = "3. 학생 삭제\n";
		m[4] = "4. 학생 목록\n";
		m[5] = "5. 종료\n";

		for (String str : m) {
			System.out.print(str);
		}
	}
}