package day7;

public class ThreadExampleUsingRunnable {//implement using runnable
public static void main(String[] args) throws InterruptedException {
	Thread thread=new Thread(new ThreadExampleNew());
	thread.start();
	//this way using thread class
	//Thread thread=new ThreadExampleNew();
	Thread task=new Thread(new ThreadEx());
	task.start();
	task.join();
	System.out.println("main is running");
}
}