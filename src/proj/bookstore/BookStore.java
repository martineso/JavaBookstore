package proj.bookstore;

import proj.book.Book;

public  interface BookStore {

	void addBook(Book book, int quantity);

	//Lists all books
	//Format - not yet configured
	//
	void listBooks();
	
	//List all books which contain the title;
	//Should find all books which contain the whole phrase and 
	//the ones which contain only a part of it.
	
	void findBook(String title);
	
	//Sell a book given the quantity
	//Should decrease the Book.issues field by
	//the @quantity value
	
	void sellBook(String input);
	
	//Delete the book with the given title and issueDate
	//Can use the this.findBook function to
	//locate the book specified
	
	void deleteBook(String title, String issueDate);
}
