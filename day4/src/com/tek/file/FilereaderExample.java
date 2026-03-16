package com.tek.file;

import java.io.FileReader;
import java.io.IOException;

public class FilereaderExample {
	
	public static void main(String[] args) throws IOException {
		FileReader reader=new FileReader("data.txt");
		int character;
		while((character=reader.read())!=-1) {
			System.out.println((char) character);
		}
		reader.close();
	}
	}


