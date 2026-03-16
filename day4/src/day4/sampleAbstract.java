package day4;

public  class sampleAbstract {
	public static void main(String[] args) {
	child c=new child();
	}
}
abstract class parent{
	 int a;
abstract void add();
final void run(){
}
}
class child extends parent{
	void add(){
		System.out.println("running");
	}
}
