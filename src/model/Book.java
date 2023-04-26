package model;


import patterns.BookObserver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Book {
    // Data members 
    private String SN;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int quantity;
    private int issuedQTY = 0;
    private LocalDate dateOfPurchase;
    
    // Create array list to contain all book objects
    public static ArrayList<Book> catalog = new ArrayList<>();
    /*
     The hash map of string and string will not work to keep track of all books borrowed by students as there are multiple quantities of the same books, 
     so when student 1 borrows book1 and student2 also borrows book1, the hash map does not remember that student1 also borrowed it, instead it will overwite 
     the owner of book1 as student 2. To solve this, I added a arraylist of books for each student that keeps track of multiple books borrowed
    */
    public static Map<String, ArrayList<Book>> issuedBooks = new HashMap<>();
    // It's a notification system
    private List<BookObserver> observers = new ArrayList<>();

    // Constructor 
    public Book(String SN, String title, String author, String publisher, double price, int quantity, LocalDate dateOfPurchase) {
        this.SN = SN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
        this.dateOfPurchase = dateOfPurchase;
    }

    // Add a student to the 'observers'. this will be notified when book is issued 
    public void addObserver(BookObserver observer) {
        observers.add(observer);
    }
    
    // Remove a student from 'observers' when book is returned 
    public void removeObserver(BookObserver observer) {
        observers.remove(observer);
    }
    
    // Notify all observers about the change in the book's availability.
    // This method is called when a book is returned, and its availability changes.
    private void notifyObservers() {
        for (BookObserver observer : observers) {
            observer.updateAvailability(this);
        }
    }
    
    // Add a book to the catalog(static array list of all books)  
    public static void addBook(Book book) {
        catalog.add(book);
    }
    
    // Issue a book to a student, check quantity if book is available and add 1 to the issued quantity, stores in the array list
    public static boolean issueBook(Book b, Student s) {
        if (b.getQuantity() > b.getIssuedQTY()) {
            b.setIssuedQTY(b.getIssuedQTY() + 1);
            issuedBooks.computeIfAbsent(s.getStdId(), k -> new ArrayList<>()).add(b);
            return true;
        }
        return false;
    }
    
    // Return a book from a student, check from array list and update array list by substracting 1 once returned 
    public static boolean returnBook(Book b, Student s) {
        ArrayList<Book> studentBooks = issuedBooks.get(s.getStdId());
        if (studentBooks != null && studentBooks.contains(b)) {
            b.setIssuedQTY(b.getIssuedQTY() - 1);
            studentBooks.remove(b);
            b.notifyObservers();
            return true;
        }
        return false;
    }
    
    // ToString 
    @Override
    public String toString() {
        return "Book{" + "SN=" + SN + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", price=" + price + ", quantity=" + quantity + ", issuedQTY=" + issuedQTY + ", dateOfPurchase=" + dateOfPurchase + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.issuedQTY != other.issuedQTY) {
            return false;
        }
        if (!Objects.equals(this.SN, other.SN)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.publisher, other.publisher)) {
            return false;
        }
        if (!Objects.equals(this.dateOfPurchase, other.dateOfPurchase)) {
            return false;
        }
        return Objects.equals(this.observers, other.observers);
    }

    // Getters and Setters 
    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssuedQTY() {
        return issuedQTY;
    }

    public void setIssuedQTY(int issuedQTY) {
        this.issuedQTY = issuedQTY;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public static ArrayList<Book> getCatalog() {
        return catalog;
    }

    public static void setCatalog(ArrayList<Book> catalog) {
        Book.catalog = catalog;
    }

    public static Map<String, ArrayList<Book>> getIssuedBooks() {
        return issuedBooks;
    }

    public static void setIssuedBooks(Map<String, ArrayList<Book>> issuedBooks) {
        Book.issuedBooks = issuedBooks;
    }
}
