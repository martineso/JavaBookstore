package proj.book;

public class Book {
	
	String name;
	String author;
	int issueDate;
	double price;
	
	
	Book(String bName, String bAuthor, int date, double bPrice) {
		
		name = bName;
		author = bAuthor;
		issueDate = date;
		price = bPrice;
		
	}
	
	String getName() {
		
		return name;
		
	}
	
	String getAuthor() {
		
		return author;
	}
	
	int getDate() {
		
		return issueDate;
	}
	
	double getPrice() {
		
		return price;
	}
	
}
