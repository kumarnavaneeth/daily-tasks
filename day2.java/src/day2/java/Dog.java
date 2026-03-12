package day2.java;

public class Dog extends Animal implements Pet{
private String breed;
public Dog(String breed) {
	this.breed = breed;
}

public String getBreed() {
	return breed;
}

public void play() {
	System.out.println("playing with dog"+getName());
}
public void bark() {
	System.out.println("Dog is barking");
}
//public void sound() {
//	System.out.println("dog is making sound");
//}
}
