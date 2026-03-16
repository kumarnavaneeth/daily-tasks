package com.tek.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class BufferExampleNew {
	private static final Logger logger=Logger.getLogger(BufferExampleNew.class.getName());
public static void main(String[] args) {
	try(BufferedReader reader=new BufferedReader(new FileReader("data.txt"))){//we are wiritng inside try ,so that we can avoid reader.close()
		String line;//by using inside try block we can avoid read.close
		while((line=reader.readLine())!=null) {
			logger.info(line);
		}
	}
	catch(IOException e) {
		logger.severe("file reading error"+e.getMessage());
	}
}
}
