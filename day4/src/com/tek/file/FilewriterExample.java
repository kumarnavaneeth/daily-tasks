package com.tek.file;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilewriterExample {
public static void main(String[] args) throws IOException {
	Scanner s=new Scanner(System.in);
	FileWriter writer=new FileWriter("output.txt");
	boolean runs=true;

	while(runs) {
	System.out.println("enter text");
	String text=s.nextLine();
	if(text.equals("exit")){
		break;
	}
	writer.write(text);
	writer.flush();
	}
	writer.close();
}
}
