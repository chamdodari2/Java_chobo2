package Java_chobo2.ch11;

import java.util.*;
import java.util.Collections;
import java.util.Iterator;

public class Ex_11_3_Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	public Ex_11_3_Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return kor + eng + math;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s, %s", name, ban, no, kor, eng, math, getTotal(), getAverage());
	}
////////////////////
	@Override
	public int compareTo(Object o) {
		if(o instanceof Ex_11_3_Student ) {
			Ex_11_3_Student tmp = (Ex_11_3_Student)o;
			return name.compareTo(tmp.name);
			
		} else {
			return -1;
		}
		
		
	
	}

}
