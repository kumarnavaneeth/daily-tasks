package basics;
import java.util.*;
import java.util.Date;
public class Car {
	String model; //enum //immutable,only getter
	String color;//mutable
	float price;//mutable
	Engine engine;  //Has-A //mutable
	String fuleType;//immutable
	String number;//immutable
	boolean insured;//mutable
	String transmission;//immutable
	List<seat> seats;//mutable
	float weight;//immutable
	String design;//immutable  //Coupe, sedan, XUV
	float mileage;//immutable
	String brand;//immutable
	boolean ev; //immutable
	Date manfacturingDate; //immutable
	List<Wheel> wheels;//immutable
}
