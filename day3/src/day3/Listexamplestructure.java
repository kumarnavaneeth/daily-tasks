package day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listexamplestructure {
	public static void main(String[] args) {
//		List<String> cities=new LinkedList<>();
		List<String> cities=createListOfCities();
		System.out.println(cities.contains("delhi"));
		System.out.println(cities.contains("delhi"));//lastindexof
		
	}
		private static void defensiveDowncasting(List<String> cities){
 
		if(cities instanceof LinkedList<String>)  {
		LinkedList<String> linkedlist=((LinkedList)cities);//downcasting //d this
		linkedlist.addFirst("a");
		}
}
 private static List<String> createListOfCities(){
	 List<String> cities=new ArrayList<>();
	 	cities.add("mangalore");
		cities.add("bengaluru");
		cities.add("kasaragod");
		return cities;
}
}