package Java_chobo2.ch14;
@FunctionalInterface
public interface TriFunction<T,U,V,R> {  //매개변수가 3개라면 이렇게 선언해야한당
	R appliy (T t, U u, V v);
	
}
