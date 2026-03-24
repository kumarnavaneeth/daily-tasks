package LogAnalyze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzerUsingFile {
public static void main(String[] args) throws IOException {
	Map<Integer,String> map=new HashMap<>();
	BufferedReader reader =new BufferedReader(new FileReader("LogContent.txt")); 
	String line;
	while((line=reader.readLine())!=null){
		map.put(Integer, line);
		System.out.println();
	}
}
}
