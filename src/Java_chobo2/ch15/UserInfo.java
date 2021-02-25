package Java_chobo2.ch15;

import java.io.Serializable;

public class UserInfo implements Serializable{
	/**
	 *  여기에 날짜적기. (버전)
	 */
	private static final long serialVersionUID = 6698772692395505953L;   //이 번호를 한개씩 바꾸는거 -> 서버에도 바꿔야함
	private String name;
	private String password;
	private int age;

	public UserInfo() {
		this("Unknown", "1111", 0); // 널로 초기화될 값을 값 넣어서 초기화해주기
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("UserInfo [%s, %s, %s]", name, password, age);
	}

}
