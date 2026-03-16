package day5;
@FunctionalInterface
interface Animal{
	void eat();
}
class Cat implements Animal{//oops
	@Override
	 public void eat() {
		System.out.println("animal eat in class");
	}
}
public class FunctionalInterfaceDemo {
public static void main(String[] args) {
//	functional();
	oopWay();
}
private static void oopWay() {
	Animal animal=new Cat();
	animal.eat();
}
private static void functional(){
	Animal animal=()->{//inline lambda expression
		System.out.println("animal eats in lambda");
	};
	animal.eat();
}
}
