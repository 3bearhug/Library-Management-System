/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patterns;

import java.time.LocalDate;
import model.Book;
import model.Student;

/**
 *
 * @author Sunhwa Lee 
 */
// Create new objects of books and students
public class LibraryFactory {
    public static Book createBook(String SN, String title, String author, String publisher, double price, int quantity, LocalDate dateOfPurchase) {
        return new Book(SN, title, author, publisher, price, quantity, dateOfPurchase);
    }

    public static Student createStudent(String stdId, String name, String contactNumber) {
        return new Student(stdId, name, contactNumber);
    }
}


