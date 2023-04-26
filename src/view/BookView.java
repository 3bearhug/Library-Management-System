/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ResourceBundle;
import model.Book;

/**
 *
 * @author Sunhwa Lee 
 */
public class BookView {
    // Display book details 
    public void printBookDetails(Book book, ResourceBundle messages) {
        System.out.println("Book Details:");
        System.out.println("SN: " + book.getSN());
        System.out.println(messages.getString("book.title") + ": " + book.getTitle());
        System.out.println(messages.getString("book.author") + ": " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Price: $" + book.getPrice());
        System.out.println("Quantity: " + book.getQuantity());
        System.out.println("Issued Quantity: " + book.getIssuedQTY());
    }
    
}
