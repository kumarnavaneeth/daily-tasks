package ListLMS;

public class Book {
int Bookid;
String title;
float price;
BookStatus status;
Book(int Bookid,String title,float price){
	this.Bookid=Bookid;
	this.title=title;
	this.price=price;
	this.status=BookStatus.AVAILABLE;
}
}
