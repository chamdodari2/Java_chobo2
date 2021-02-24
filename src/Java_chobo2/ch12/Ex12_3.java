package Java_chobo2.ch12;

import Java_chobo2.ch12.Fruit.Apple;

interface Eatable {
}

class Fruit implements Eatable {

	@Override
	public String toString() {
		return "Fruit";

	}

	class Apple extends Fruit {

		@Override
		public String toString() {
			return "Apple";
		}

	}
}

class Grape extends Fruit {

	@Override
	public String toString() {
		return "Grape";
	}

}

class Toy {

	@Override
	public String toString() {
		return "Toy ";
	}

}

class FruiteBox<T extends Fruit & Eatable> extends Box<T> {
}

public class Ex12_3 {

	public static void main(String[] args) {
		FruiteBox<Fruit> fruitBox = new FruiteBox<Fruit>();
		FruiteBox<Apple> appleBox = new FruiteBox<Apple>();
		FruiteBox<Grape> grapeBox = new FruiteBox<Grape>();

//		FruiteBox<Grape> grape2Box = new FruiteBox<Apple>();
//		FruiteBox<Toy> toytBox = new FruiteBox<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());		
		grapeBox.add(new Grape());

		System.out.println("fruitBox - " + fruitBox);
		System.out.println("appleBox -" + appleBox);
		System.out.println("GrapeBox -" + grapeBox);

	}

}
