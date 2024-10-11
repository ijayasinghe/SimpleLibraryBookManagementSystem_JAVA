import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.Month;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();

        Path file =
                Paths.get("/Users/ireshaj/Documents/DOUGLAS College/2nd Sem- Winter 2024/Adv Integrated Software Dev/Assignments/Assignment2/Library.txt");

        String isAvailable,type,title,author,ageOrArea = null;
        int noOfBooks;

        try
        {
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            noOfBooks = Integer.parseInt(reader.readLine());
            isAvailable = reader.readLine();

            while (isAvailable!=null)
            {
                type = reader.readLine();
                title = reader.readLine();
                author = reader.readLine();
                ageOrArea = reader.readLine();
                System.out.println(isAvailable+","+type+","+title+","+author+","+ageOrArea);

                if(type.equals("Text")){
                    books.add(new TextBook(Boolean.valueOf(isAvailable),title,author, TextBook.SubjectArea.valueOf(ageOrArea)));
                }
                else{
                    books.add(new ChildrensBook(Boolean.valueOf(isAvailable),title,author, Integer.parseInt(ageOrArea)));
                }
                isAvailable = reader.readLine();
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }

    }

    public void listAvailableBooks() {
        System.out.println("\nThe following books are available: ");
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).isAvailable()) {
                System.out.println((i+1) + " " + books.get(i));
            }
        }
    }

    public Book borrowBook(int position) throws InvalidBookSelectionException  {
        Book book = null;
        try {
            if (books.get(position).isAvailable()) {
                books.get(position).borrow();
                book = books.get(position);
            } else {
                System.out.println("Invalid selection. Please pick a different book.");
            }
        } catch(Exception e) {
            throw new InvalidBookSelectionException(position);
        }
        return book;

    }


}
