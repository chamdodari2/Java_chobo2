package Java_chobo2.ch11;

public class Student3 { //학생번호, 이름, 과목(국영수), 총점, 평균
	//멤버변수   
	int stdNo; //학번
	String name;  //성명
	int kor;
	int eng;
	int math;
	//자동초기화하기 : 알쉬S 
	//매개변수?
	
	public Student3(int stdNo, String name, int kor, int eng, int math) { //매개변수가 없는 생성자는 없다
		this.stdNo = stdNo;  //매개변수와 지역변수 이름이 같으면 this가 빠지면 지역변수가 우선이된다.
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int total() {  //합계
		 return kor+eng+math;
		
	}
	
	public double avg(){  //평균
		return total()/3D;
		
		
		
	}
	@Override
	public String toString() {
		return String.format("%3d %5s %3d %3d %3d %3d %.1f", //보는방법 수정
				stdNo, name,kor, eng, math, total(), avg());
	}	}
	

	
	

