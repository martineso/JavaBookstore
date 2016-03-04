package proj.book;

import proj.bookstore.BookStore;


import java.util.*;

/**
 * Created by Kristiyan on 03-Mar-16.
 */
public class Test extends Book implements BookStore {

    Set<Book> bookList = new HashSet<>();

   public Test(String name, String author, String publisher, int issueDate, int copies, double price, boolean isForeign) {
        super(name, author, publisher, issueDate, copies, price, isForeign);

    }

    @Override
    public void addBook(Book book, int quantity) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i<bookList.size();i++){
            System.out.println("Enter the name of the book : ");
            String title = sc.next();
            book.setName(title);
            System.out.println("Enter name of author :");
            String author = sc.next();
            book.setAuthor(author);
            System.out.println("Enter publisher : ");
            String publisher = sc.next();
            book.setPublisher(publisher);
            System.out.println("Enter issue date : ");
            int date = sc.nextInt();
            book.setIssueDate(date);
            System.out.println("Enter number of copies : ");
            quantity = sc.nextInt();
            book.setCopies(quantity);
            System.out.println("Enter price of the book : ");
            Double price = sc.nextDouble();
            book.setPrice(price);
            System.out.println("Is the book foreign ? (true/false) : ");
            boolean isForeign = sc.nextBoolean();
            book.setForeign(isForeign);

            bookList.add(book);

        }
    }

    @Override
    public void listBooks() {
        for(Book book : bookList){
            System.out.println(book.getName() + book.getCopies());
        }

    }

    @Override
    public void findBook(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter book name : ");
         title = sc.nextLine();
              for(Book book :bookList){
                  if(book.getName().contains(title)){
                      System.out.println(book);
                  }
              }
            }

    @Override
    public void sellBook(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the name of the book you would like to buy : ");
        input = sc.nextLine();
        for(Book book : bookList)
        if(input.equals(book.getName())){
            book.setCopies(book.getCopies()-1);
            break;
    }
    }

    @Override
    public void deleteBook(String title, String issueDate) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the name of the book you would like to delete : ");
        title = sc.nextLine();

       for(Book book : bookList){
           if(title.equals(book.getName())){
               bookList.remove(title.indexOf(title));
           }
       }
    }

    public static void main(String[] args) {

    }

}