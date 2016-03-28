package projectPragmatic.utils;

import projectPragmatic.model2.Book;

import java.io.*;
import java.util.*;

/**
 * Created by Kristiyan on 26-Mar-16.
 */
public class SaveLoad {

    public static boolean save(Collection<Book> books, String fileName) throws IOException {

        if (books == null || fileName == null) {
            return false;
        }

        try (
                FileWriter writer = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                //using to set new line ( not all the content to be on the same line )
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            for (Book book : books) {
                StringBuilder builder = new StringBuilder();
                builder.append(book.getName());
                builder.append(",");
                builder.append(book.getAuthor());
                builder.append(",");
                builder.append(book.getPublisher());
                builder.append(",");
                builder.append(book.getDate());
                builder.append(",");
                builder.append(book.getCopies());
                builder.append(",");
                builder.append(book.getPrice());
                builder.append(",");
                builder.append(book.isForeign());
                builder.append(",");
                builder.append(book.getId());

                printWriter.println(builder.toString());
            }
            return false;
        }
    }

    public static  Collection<Book> load(String fileName) throws IOException {
        if(fileName == null){
            return new ArrayList<>();
        }

        Collection<Book> books = new ArrayList<>();
        try(
                FileInputStream reader = new FileInputStream(fileName);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(reader);
                Scanner input = new Scanner(bufferedInputStream))
        {
            while(input.hasNextLine()){
                String line = input.nextLine();
                String[] tokens = line.split(",");
                if(tokens.length == 8){
                    Book book = new Book(tokens[0],tokens[1],tokens[2],tokens[3],
                            Integer.valueOf(tokens[4]),Double.valueOf(tokens[5]),Boolean.valueOf(tokens[6]), UUID.fromString(tokens[7]));
                    books.add(book);
                }
            }
        }

        return books;
    }
}

