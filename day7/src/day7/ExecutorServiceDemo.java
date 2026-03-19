package day7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Worker2 implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+"started");
		try {
			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println(Thread.currentThread().getName()+"finished");
		}
	}
}
public class ExecutorServiceDemo {
public static void main(String[] args) {
	ExecutorService executor1=Executors.newFixedThreadPool(10);//pool cannot be -1 or 0 etc,max 10 threads 
	executor1.submit(new Worker2());                                //if it uses then threads are created 
	executor1.shutdown();
}
}
