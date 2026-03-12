package day2.java;

public abstract class Animal {
private String name;
private int age;

public void sound() {
	System.out.println("animal is making sound");
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
