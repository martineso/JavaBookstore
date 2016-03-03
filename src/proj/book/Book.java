package proj.book;

public class Book {

	private String name, author;
	private int issueDate, copies;
	private double price;


	Book(String name, String author, int issueDate, int copies, double price) {

		this.name = name;
		this.author = author;
		this.issueDate = issueDate;
		this.copies = copies;
		this.price = price;

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

}
