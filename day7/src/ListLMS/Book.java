package ListLMS;
import static ListLMS.ValidateUtils.*;
public class Book {
int Bookid;
String title;
float price;
BookStatus status;
Book(int Bookid,String title,float price){
	if(!validateStringValues(title)|| !validatePriceValue(price)|| !validateIdValue(Bookid)) {
		throw new IllegalArgumentException("invalid input");
	}
	this.Bookid=Bookid;
	this.title=title;
	this.price=price;
	this.status=BookStatus.AVAILABLE;
}
public BookStatus getStatus() {
	// TODO Auto-generated method stub
	return status;
}
@Override
public String  toString() {
	return "book id: " +Bookid+ "title: " +title+ "price: " +price + "status: " +status;
}
}
