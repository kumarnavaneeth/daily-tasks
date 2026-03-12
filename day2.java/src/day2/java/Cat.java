package day2.java;

public class Cat extends Animal implements Pet {
private String breed;
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("playing with cat"+getName());
	}

}
