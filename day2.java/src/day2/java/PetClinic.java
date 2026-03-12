package day2.java;

import java.util.List;
import java.util.*;
public class PetClinic {
	public static void main(String[] args) {
		Dog dog=new Dog("husky");
		Pet dog1=new Dog("german");
		dog.setName("ramb");
		Cat cat=new Cat();
		cat.setName("billu");
		dog.getBreed();
		List<Pet> pets=new ArrayList<Pet>();
		pets.add(dog);
		pets.add(dog1);
		pets.add(cat);
		pets.forEach((Pet)->Pet.play());
		methodOverriding();
	}
		//
		//overriding
		 static void methodOverriding() {
			Pet pet=new Dog("husky");
			Animal animal=(Animal)pet;
			animal.sound();
		}
		
}
