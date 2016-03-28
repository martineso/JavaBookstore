package projectPragmatic.controllers;

import projectPragmatic.model2.*;
import projectPragmatic.model2.BookStore;
import projectPragmatic.utils.SaveLoad;

import java.io.*;
import java.util.*;

/**
 * Created by Kristiyan on 03-Mar-16.
 */
public class UserInputController {

    private Scanner scanner;
    private projectPragmatic.model2.BookStore bookStore;

    enum MenuOption{
        ADD,
        SEARCH,
        SHOW,
        SELL,
        DELETE,
        INVALID,
        EXIT
    }

    public UserInputController() throws IOException {
        scanner = new Scanner(System.in);
        bookStore = new BookStore();
        SaveLoad.load("books.csv");

    }

    public void start() throws IOException {
        boolean shouldExit = false;
        do {

            MenuOption selectedOption = showMenu();
            switch(selectedOption) {
                case ADD:
                    addBook();
                    break;
                case SEARCH:
                    search();
                    break;
                case SHOW:
                    showContent();
                    break;
                case SELL:
                    sellBook();
                    break;
                case DELETE:
                    deleteBook();
                    break;
                case EXIT:
                    shouldExit = true;
                    break;
                case INVALID:
                    System.out.println("Option is not valid!!!");
                    break;
            }
        } while(shouldExit == false);

        System.out.println("Bye!!!");
    }

    private MenuOption showMenu() {
        System.out.println("--- MENU ---");
        System.out.println("1. Enter new book");
        System.out.println("2. Search for book");
        System.out.println("3. Show content of bookstore ");
        System.out.println("4. Sell book");
        System.out.println("5. Delete book");
        System.out.println("6. Exit");
        System.out.println();
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice) {
            case 1: return MenuOption.ADD;
            case 2: return MenuOption.SEARCH;
            case 3: return MenuOption.SHOW;
            case 4: return MenuOption.SELL;
            case 5: return MenuOption.DELETE;
            case 6: return MenuOption.EXIT;
            default: return MenuOption.INVALID;
        }
    }

    private void addBook() throws IOException {
        System.out.println("Type the name of the book : ");
        String name = scanner.nextLine();
        System.out.println("Type the name of the author of the book : ");
        String authorName = scanner.nextLine();
        System.out.println("Type the name of the publisher of the book : ");
        String publisher = scanner.nextLine();
        System.out.println("Type the price of the book : ");
        double price = scanner.nextDouble();
        System.out.println("Add number of copies of given book : ");
        int copies = scanner.nextInt();
        System.out.println("Add issueDate of the book : ");
        String issueDate = scanner.next();
        System.out.println("Type if the book is foreign or not ( True / False ) : ");
        boolean isForeign = scanner.nextBoolean();

        Book book = new Book(name,authorName,publisher,issueDate,copies,price,isForeign,UUID.randomUUID());

        bookStore.addBookEntity(book);
}

    private void search(){
        System.out.println("Enter book name : ");
        String bookName = scanner.nextLine();
        List<Book> books = bookStore.search(bookName, false);
        books.forEach(book -> printBookInfo(book));
    }
    private void printBookInfo(Book book) {
        if(book != null){
            System.out.println(book.toString());
        } else System.out.println("No such book !");
    }

    private void showContent() {
        List<Book> bookEntities = bookStore.showContent();
        System.out.println("This bookstore has the following books: ");
        for (Book book : bookEntities) {
            System.out.println(book.toString());
        }
    }

    private void deleteBook(){
        System.out.println("Enter the name of the book : ");
        String name = scanner.nextLine();
        boolean result = bookStore.deleteBook(name);
        if (result) {
            System.out.println("Book was deleted");
        } else {
            System.out.println("The provided book was not part of the bookstore");
        }
    }

    private void sellBook(){
        System.out.println("Enter the name of the book you want to buy : ");
        String name = scanner.nextLine();
        System.out.println("How much copies of the book you want to buy ? : ");
        int quantity = Integer.parseInt(scanner.nextLine());
        List<Book> book = bookStore.search(name,true);
        bookStore.sellBookEntity(book.get(0),quantity);

    }


}


