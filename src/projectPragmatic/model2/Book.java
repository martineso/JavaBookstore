package projectPragmatic.model2;

import java.io.Serializable;
import java.util.UUID;

public class Book  {

	private String name, author, publisher,issueDate;
	private int copies;
	private double price;
	private boolean isForeign;
	private UUID id;

	public Book(String name, String author, String publisher,String issueDate, int copies,double price,boolean isForeign, UUID id) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.issueDate = issueDate;
		this.copies = copies;
		this.price = price;
		this.isForeign = isForeign;
		this.id = id;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Book() {

	}

	public String getName() {
		return name;
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

	public void setIssueDate(String issueDate) {
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

	public String getAuthor() {

		return author;
	}

	public String getDate() {

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

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", issueDate=" + issueDate +
				", copies=" + copies +
				", price=" + price +
				", isForeign=" + isForeign +
				'}';
	}
}
