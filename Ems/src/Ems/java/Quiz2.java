package Ems.java;

public class Quiz2 {
public static void main(String[] args) {
	Parent p=new Child();
	p.show();
}
}
class Parent{
	static void show() {
		System.out.println("parent");
	}
}
class Child extends Parent{
	static void show() {
		System.out.println("child");
	}
}
