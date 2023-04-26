/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ResourceBundle;
import model.Book;
import view.BookView;

/**
 *
 * @author Sunhwa Lee 
 */
public class BookController {
    private Book model;
    private BookView view;

    public BookController(Book model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void setBookSN(String sn) {
        model.setSN(sn);
    }

    public String getBookSN() {
        return model.getSN();
    }

    public void setBookTitle(String title) {
        model.setTitle(title);
    }

    public String getBookTitle() {
        return model.getTitle();
    }

    public void setBookAuthor(String author) {
        model.setAuthor(author);
    }

    public String getBookAuthor() {
        return model.getAuthor();
    }

    public void setBookPublisher(String publisher) {
        model.setPublisher(publisher);
    }

    public String getBookPublisher() {
        return model.getPublisher();
    }

    public void setBookPrice(double price) {
        model.setPrice(price);
    }

    public double getBookPrice() {
        return model.getPrice();
    }

    public void setBookQuantity(int quantity) {
        model.setQuantity(quantity);
    }

    public int getBookQuantity() {
        return model.getQuantity();
    }

    public void setBookIssuedQTY(int issuedQTY) {
        model.setIssuedQTY(issuedQTY);
    }

    public int getBookIssuedQTY() {
        return model.getIssuedQTY();
    }

    // Updates the view to display the details of the book    
    public void updateView(ResourceBundle messages) {
        view.printBookDetails(model, messages);
    }
}

