package proj.book;

public class Book {

	private String name, author, publisher;
	private int issueDate, copies;
	private double price;
	private boolean isForeign;

	public Book(String name, String author, String publisher, int issueDate, int copies, double price, boolean isForeign) {


		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.issueDate = issueDate;

		this.copies = copies;
		this.price = price;
		this.isForeign = isForeign;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setIssueDate(int issueDate) {
		this.issueDate = issueDate;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setForeign(boolean foreign) {
		isForeign = foreign;
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
