package day4;

import java.util.logging.Logger;

public class LoggingExample {
private static final Logger logger=Logger.getLogger(LoggingExample.class.getName());//final because we will not modify the object ref
public static void main(String[] args) {//static because we will not create many objects
	
	logger.info("Application started");
	logger.warning("low memory warning");
	logger.severe("System failure");
}
}
