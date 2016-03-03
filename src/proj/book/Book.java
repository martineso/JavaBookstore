package proj.book;

public class Book {

	private String name, author, publisher;
	private int issueDate, copies;
	private double price;
	private boolean isForeign;


	Book(String name, String author, String publisher, int issueDate, int copies, double price, boolean isForeign) {
		

		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.issueDate = issueDate;
		this.copies = copies;
		this.price = price;
		this.isForeign = isForeign;

	}

	public String getName() {

		return name;

	}

	public String getAuthor() {

		return author;
	}

	public int getDate() {

		return issueDate;
	}

	public double getPrice() {

		return price;
	}
	
	public int getCopies() {
		
		return copies;
		
	}
	
	public String getPublisher() {
		
		return publisher;
	
	}
	
	public boolean isForeign() {
		return isForeign;
	}

}
