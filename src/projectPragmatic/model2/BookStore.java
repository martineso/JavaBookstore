package projectPragmatic.model2;

import projectPragmatic.utils.SaveLoad;

import java.io.*;
import java.util.*;

/**
 * Created by Kristiyan on 20-Mar-16.
 */
public class BookStore {

    private Map<String,Book> bookList;

    public BookStore() throws IOException {

        bookList = new HashMap<>();
        try {
            Collection<Book> books = SaveLoad.load("books.csv");
            for (Book book : books) {
                bookList.put(book.getName(), book);
            }
        }catch (Exception e){
            System.out.println("No such file");
        }
    }

        public void addBookEntity(Book book) throws IOException {
            bookList.put(book.getName(),book);
            save();
        }

        public boolean deleteBook(String word){
            Book book = bookList.remove(word);
        return bookList.containsKey(word);
        }

        public boolean sellBookEntity(Book book, int quantity){
            if(book.getCopies()>0){
                book.setCopies(book.getCopies() - quantity);
                return true;
            }
            return false;
        }

        public List<Book> showContent(){
            List<Book> allWordEntities = new ArrayList<>(bookList.values());
            Collections.sort(allWordEntities, new Comparator<Book>() {

                @Override
                public int compare(Book o1, Book o2) {
                    String firstWord = o1.getName();
                    String secondWord = o2.getName();

                    return firstWord.compareTo(secondWord);
                }
            });
            return allWordEntities;
        }

    public List<Book> search(String word ,boolean exactSearch){
        if(exactSearch) {
            if(bookList.containsKey(word)){
                return Arrays.asList(bookList.get(word));
            } else {
                return Collections.emptyList();
            }
        } else {
            List<Book> result = new ArrayList();
            for (Map.Entry<String, Book> entry : bookList.entrySet())
                if (entry.getKey().contains(word))
                    result.add(entry.getValue());

            return result;
        }
    }

    private void save() throws IOException {
        SaveLoad.save(bookList.values(),"books.csv");
    }
}

