package com.tek.logAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoganalizerAssignment {
	public static void main(String[] args) throws IOException  {
		countLogMessageFromFile();
	}
	private static void countLogMessageFromFile() throws IOException {
		Map<String,Integer> map=new HashMap<>();
		try {
		BufferedReader reader =new BufferedReader(new FileReader("systemlog.txt")); 
		String line;
		while((line=reader.readLine())!=null){
			if(line.contains(":")) {
				String logMessageType=line.split(":")[0].trim();
	            map.put(logMessageType, map.getOrDefault(logMessageType, 0) + 1);
			}
		}
		reader.close();
		}
		catch(IOException e) {
			System.out.println("error reading file");
		}
		 for (Map.Entry<String, Integer> entry : map.entrySet()) {
	         System.out.println(entry.getKey() + ":" + entry.getValue());
	     }
	}
	}


