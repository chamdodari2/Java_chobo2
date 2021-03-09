package Java_chobo2.ch14.stream;  //논리적사고력 필요! 코드를 그대로 가져다쓰면안된당. 이해하고써야함!

public class Student implements Comparable<Student> {

	private String name;
	private int ban;
	private int totalScore;

	public Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, totalScore=%s]", name, ban, totalScore);
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (this.totalScore - o.totalScore)*-1;
	}

}
