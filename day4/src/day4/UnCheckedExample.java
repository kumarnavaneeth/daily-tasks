package day4;

public class UnCheckedExample {
public static void main(String[] args) {
	//String str=null;
	//System.out.println(str.length());
	//************
	//validateAge(17);
	//System.out.println("finished");//it will not print so we need to add try catch
//	try {
//		validateAge(17);
//	} catch (IllegalArgumentException e) {//dont catch unchecked exception
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//	System.out.println("finished");
	try {
		validateAge(17);
	} catch (InvalidAgeException e) {//dont catch unchecked exception
		// TODO: handle exception
		e.printStackTrace();
	}
	System.out.println("finished");//now it will run this
}
private static void validateAge(int age) {
//	if(age<18) {
//		throw new IllegalArgumentException("age must be abbove 18");
//	}
	//2nd
	if(age<18) {
		throw new InvalidAgeException("age must be 18+");
	}
}
}
