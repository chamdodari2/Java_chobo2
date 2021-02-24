package Java_chobo2.ch12;

import java.util.ArrayList;
import java.util.Iterator;

class Prodeuct {
}

class Tv extends Prodeuct {
}

class Audio extends Prodeuct {
} // 얘들이 상속관계여도 밑에쪽에서는 별개로 인식된다

public class TestMain2 {

	public static void main(String[] args) {
		ArrayList<Tv> listTv = new ArrayList<Tv>();
//		ArrayList<Prodeuct> listProduct = new ArrayList<Tv>(); 불가능하다. 각각 따로
		ArrayList<Prodeuct> listProdeuct = new ArrayList<>();

		listTv.add(new Tv());
		listProdeuct.add(new Prodeuct());
		listProdeuct.add(new Tv());
		listProdeuct.add(new Audio());

		////////
		Iterator<Prodeuct> it = listProdeuct.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
