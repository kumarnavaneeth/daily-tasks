package day4;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
public class CheckedExample {
public static void main(String[] args) {
//	try {
//		FileReader file=new FileReader("data.text");
//	} catch (FileNotFoundException e) {
//		// TODO: handle exceptionc
//		System.out.println("file not found");
//		
//	}
	try {
		readFile();
	} catch (FileNotFoundException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
} 
private static void readFile() throws FileNotFoundException{
	FileReader file=new FileReader("data.txt");
}
}
