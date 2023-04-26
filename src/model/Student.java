package model;


import patterns.BookObserver;
import model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements BookObserver {
    // Data members
    private String stdId;
    private String name;
    private String contactNumber;
    private boolean availabilityUpdated;

    // Constructer 
    public Student(String stdId, String name, String contactNumber) {
        this.stdId = stdId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    // Borrow a book for a student, return true
    public boolean borrow(Book b) {
        return Book.issueBook(b, this);
    }
    
    // Return a book, return true 
    public boolean toReturn(Book b) {
        return Book.returnBook(b, this);
    }
    
    // Get all books assign to students from hashmap.issuedbooks 
    public List<Book> getIssuedBooks() {
        ArrayList<Book> issuedBooks = Book.issuedBooks.get(stdId);
        return issuedBooks == null ? new ArrayList<>() : new ArrayList<>(issuedBooks);
    }
    
    // notify students when book is available and book is returned 
    @Override
    public void updateAvailability(Book book) {
        System.out.println("Book " + book.getTitle() + " is now available for student: " + this.getName());
        setAvailabilityUpdated(true);
    }
    
    // Tostring 
    @Override
    public String toString() {
        return "Student{" + "stdId=" + stdId + ", name=" + name + ", contactNumber=" + contactNumber + '}';
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
        final Student other = (Student) obj;
        if (!Objects.equals(this.stdId, other.stdId)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.contactNumber, other.contactNumber);
    }
   
    // Getters and setters 
    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public void setAvailabilityUpdated(boolean availabilityUpdated) {
        this.availabilityUpdated = availabilityUpdated;
    }

    public boolean isAvailabilityUpdated() {
        return availabilityUpdated;
    }
    
    
    
}
