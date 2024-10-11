import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

    public static final int MAX_NO_OF_BOOOKS = 4;
    public static final int RENTAL_DURATION = 21;

    public static void main(String[] args) {
        Library library = new Library();

        ArrayList<Book> borrowedBooks= new ArrayList<Book>();
        int noOfBorrowedBooks = 0;
        int selection = -1;
        do {
            library.listAvailableBooks();
            Scanner inputDevice = new Scanner(System.in);
            System.out.print("Please enter number of a book to borrow, or 0 to exit >>> ");
            do {
                try {
                    selection = -1; // so that we can only continue once user enters a valid selction after an invalid one
                    selection = inputDevice.nextInt();
                } catch(InputMismatchException e) {
                    System.out.println("Please enter a valid choice!");
                    inputDevice.nextLine(); // if letter was entered, read away enter
                }
            } while (selection < 0);
            if(selection > 0) {
                try {
                    Book book = library.borrowBook(selection - 1);
                    borrowedBooks.add(book);
                    noOfBorrowedBooks++;
                } catch(InvalidBookSelectionException e) {
                    System.out.println(selection + " was an invalid choice. Please enter the number of an available book. ");
                }
            }
        } while(selection != 0 && noOfBorrowedBooks < MAX_NO_OF_BOOOKS);

        displaySummary(borrowedBooks, noOfBorrowedBooks);

        updateTextFile(borrowedBooks);


    }

    private static void displaySummary(ArrayList<Book> books, int number) {
        System.out.println("\nYou borrowed the following books:");
        for(int i = 0; i < number; i++) {
            System.out.println(books.get(i));
        }
        System.out.println("The due date is: " + LocalDate.now().plusDays(RENTAL_DURATION));
    }
    private static void updateTextFile(ArrayList<Book> books){

        Path file =
                Paths.get("/Users/ireshaj/Documents/DOUGLAS College/2nd Sem- Winter 2024/Adv Integrated Software Dev/Assignments/Assignment2/Library_new.txt");

        Employee emp= new Employee();

        try
        {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));


            writer.write(emp.getName(),0,emp.getName().length());
            writer.newLine();


            output.close();
            //System.out.println("last line");
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }


    }


}

