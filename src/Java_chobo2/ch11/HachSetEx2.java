package Java_chobo2.ch11; //해시셋을 정확하게 사용하려면 이퀄즈와 헤드코드를 해주야한다

import java.util.HashSet;

class Person{  //
	String name;
	int age;
	
	public Person(String name, int age) {  //필드를 통해
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s]", name, age);
	}
	//알트 쉬프트 s - 해시코드
	@Override
	public int hashCode() {		
		return (name + age).hashCode();   //이렇게 수정해도 된다. 수정하면 같은값으로 뜨고 트루가 나온다 
	}
	@Override
	public boolean equals(Object obj) {  //이렇게 수정
		if(obj instanceof Person) {
			Person object = (Person) obj ;
			if(this.name.equals(object.name) && this.age == object.age) {
				return true;
			}
		}return false;
		}
		
		/*
		 * if (this == obj) return true; if (obj == null) return false; if (getClass()
		 * != obj.getClass()) return false; Person other = (Person) obj; if (age !=
		 * other.age) return false; if (name == null) { if (other.name != null) return
		 * false; } else if (!name.equals(other.name)) return false; return true;
		 */
	}
	
	

public class HachSetEx2 {

	public static void main(String[] args) {
//		boolean isEquals = extracted();
//		System.out.println("p1 ==p2 " + isEquals);  // false가 출력된다.
		Person p1 = new Person("전수린",40);
		Person p2 = new Person("전수린",40);
		Person p3 = new Person("우정아",40);
		Person p4 = new Person("정민강",30);  
		
		//해시셋에 입력하면 3명만 나온다.  같으면 출력? 추가? 하지않는다? 같은걸로 인식?
		HashSet<Person> ban =  new 	HashSet<Person> ();
		ban.add(p1);
		System.out.println("size " + ban.size());
		
		ban.add(p2);
		System.out.println("size " + ban.size());
		
		ban.add(p3);
		System.out.println("size " + ban.size());
		ban.add(p4);
		System.out.println("size " + ban.size());
		
	}

	public static boolean extracted() {
		Person p1 = new Person("전수린",40);
		

		int hashCode1 = p1.hashCode();  //찍어보기
		int hashCode2 = p1.hashCode();
		
		System.out.printf("%d = %d%n",hashCode1,hashCode2);  //366712642 = 366712642
//		p1.age= 30;
		
		int hashCode3 = p1.hashCode();
		System.out.println("hashCode3 "+ hashCode3);  //hashCode3 366712642 동일하게 나온다.
		
//		Person p2 = new Person("우정아",50);
		Person p2 = new Person("전수린",40);
		int hashCode4 = p2.hashCode();
		System.out.println("hashCode4 "+ hashCode4);  //hashCode4 2101973421 다르게 출력된다.
		
		//각각의 값이 일치하는지 확인하기
		boolean isEquals = p1.equals(p2);
		return isEquals;
	}

}
