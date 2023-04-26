package main;

import controller.BookController;
import controller.StudentController;
import model.Student;
import model.Book;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import patterns.LibraryFactory;
import view.BookView;
import GUI.MainFrame;
import java.util.List;
import view.StudentView;

public class Driver {
    public static void main(String[] args) {
        
        MainFrame mf = new MainFrame();
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mf.setVisible(true);

        // Create some books
        Book book1 = new Book("B001", "Book1", "Author1", "publisher1", 10.0, 5, LocalDate.of(2021, 4, 15));
        Book book2 = new Book("B002", "Book2", "Author2", "publisher2", 20.0, 3, LocalDate.of(2021, 2, 25));

        // Add books to the catalog
        Book.addBook(book1);
        Book.addBook(book2);

        // Create some students
        Student student1 = new Student("2295484", "Amy", "438-880-1234");
        Student student2 = new Student("2295488", "Chad", "438-880-5678");

        // Create views and controllers for books and students
        BookView bookView = new BookView();
        StudentView studentView = new StudentView();
        ResourceBundle messages = ResourceBundle.getBundle("i18n.ApplicationMessages_en_EN", Locale.ENGLISH);
        BookController bookController1 = new BookController(book1, bookView);
        BookController bookController2 = new BookController(book2, bookView);
        StudentController studentController1 = new StudentController(student1, studentView);
        StudentController studentController2 = new StudentController(student2, studentView);

        // Display book and student details
        bookController1.updateView(messages);
        bookController2.updateView(messages);
        studentController1.updateView(messages);
        studentController2.updateView(messages);

        // Add students as observers to the books
        book1.addObserver(student1);
        book2.addObserver(student2);

        // Students borrow books
        System.out.println("\nStudents issued books:");
        studentController1.borrowBook(book1);
        studentController1.borrowBook(book2);
        studentController2.borrowBook(book2);

        // Display issued books for each student
        System.out.println("\nIssued books for student 1:");
        List<Book> issuedBooksStudent1 = student1.getIssuedBooks();
        for (Book book : issuedBooksStudent1) {
            System.out.println(book);
        }

        System.out.println("\nIssued books for student 2:");
        List<Book> issuedBooksStudent2 = student2.getIssuedBooks();
        for (Book book : issuedBooksStudent2) {
            System.out.println(book);
        }

        // Students return books
        System.out.println("\nStudents returned books:");
        studentController1.returnBook(book1);
        studentController1.returnBook(book2);

        // Display issued books for each student after returning books, check if quantity has been updated 
        System.out.println("\nStudent1 books after returning:");
        issuedBooksStudent1 = student1.getIssuedBooks();
        for (Book book : issuedBooksStudent1) {
            System.out.println(book);
        }

        System.out.println("\nStudent2 books after returning::");
        issuedBooksStudent2 = student2.getIssuedBooks();
        for (Book book : issuedBooksStudent2) {
            System.out.println(book);
        }

        // Remove students as observers from the books
        book1.removeObserver(student1);
    }
}
