package Java_chobo2.ch12;

import java.util.ArrayList;

public class Box<T> { // 선언할떄  
//	private ArrayList<T> list = new ArrayList<T>();  //이렇게 명시적으로 초기화 해도 되고,
	private ArrayList<T> list;  //이렇게 명시적으로 초기화 해도 되고,
	
	

	

	public Box() {
		list = new ArrayList<T>();
	}

	public void add(T item) {
		list.add(item);

	}

	public T get(int idx) {
		return list.get(idx);
	}
	
	public ArrayList<T> getList() {
		return list;
	}
	
	public int size() {
		return list.size();
	}

	@Override
	public String toString() {
		return String.format("Box [%s]", list);
	}
	
}
