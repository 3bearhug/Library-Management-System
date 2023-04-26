package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Sunhwa Lee 
 */
public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/library_mgt_sw";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root12345!";

    public static void main(String[] args) throws SQLException {
        DatabaseConnection db = new DatabaseConnection();
        db.readIssuedBooks();
        db.readBooks();
        db.readStudents();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    // SQL query to add value into IssuedBooks throughout GUI 
    public void insertIssuedBooks(String sn, int stid, String stname, String studentcontact) throws SQLException {
        String query = "insert into IssuedBooks (sn, stid, stname, studentcontact) VALUES (?, ?, ?, ?)";

        try (Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, sn);
            pstmt.setInt(2, stid);
            pstmt.setString(3, stname);
            pstmt.setString(4, studentcontact);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SQL query to read values from IssuedBooks throughout GUI 
    public String readIssuedBooks() throws SQLException {
        String query = "select * from IssuedBooks";

        try (Connection con = connect();
             Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(query)) {

            ResultSetMetaData resultMD = result.getMetaData();
            
            // html codes to create a table 
            StringBuilder bookData = new StringBuilder("<html><head><style>"
                    + "table {border-collapse: collapse;}"
                    + "th, td {border: 1px solid black; padding-right: 4px;}"
                    + "</style></head><body><table>");

            
            bookData.append("<tr>");
            bookData.append("<th>ID</th>");
            bookData.append("<th>Book ID</th>");
            bookData.append("<th>Student ID</th>");
            bookData.append("<th>Student Name</th>");
            bookData.append("<th>Student Contact</th>");
            bookData.append("<th>Issue Date</th>");
            bookData.append("</tr>");

            
            while (result.next()) {
                bookData.append("<tr>");

                for (int i = 1; i <= resultMD.getColumnCount(); i++) {
                    bookData.append("<td>").append(result.getString(i)).append("</td>");
                }

                bookData.append("</tr>");
            }
            bookData.append("</table></body></html>");

            System.out.println(bookData);
            return bookData.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // SQL query to delete value from IssuedBooks table throughout GUI 
    public void deleteIssuedBooks(int id) throws SQLException {
        String query = "delete from IssuedBooks where id = ?";

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // SQL query to add value into Students table  throughout GUI
    public void insertStudent(int studentId, String name, String contact) throws SQLException {
        String query = "insert into Students (StudentId, Name, Contact) VALUES (?, ?, ?)";

        try (Connection con = connect();
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            pstmt.setString(2, name);
            pstmt.setString(3, contact);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Succesfully added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SQL query to read value from Students table throughout GUI  
    public String readStudents() throws SQLException {
        String query = "select * from Students";

        try (Connection con = connect();
             Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(query)) {

            ResultSetMetaData resultMD = result.getMetaData();
            
            // html codes to create a table 
            StringBuilder studentData = new StringBuilder("<html><head><style>"
                    + "table {border-collapse: collapse;}"
                    + "th, td {border: 1px solid black; padding: 4px;}"
                    + "</style></head><body><table>");

            
            studentData.append("<tr>");
            studentData.append("<th>Student ID</th>");
            studentData.append("<th>Name</th>");
            studentData.append("<th>Contact</th>");
            studentData.append("</tr>");

            // Adding row data
            while (result.next()) {
                studentData.append("<tr>");

                for (int i = 1; i <= resultMD.getColumnCount(); i++) {
                    studentData.append("<td>").append(result.getString(i)).append("</td>");
                }

                studentData.append("</tr>");
            }
            studentData.append("</table></body></html>");

            System.out.println(studentData);
            return studentData.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // SQL query to delete value from Students table throughout GUI 
    public void deleteStudent(int studentId) throws SQLException {
        String query = "delete from Students where StudentId = ?";

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Succesfully deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertBook(String sn, String title, String author, String publisher, double price, int quantity, int issuedQTY, Timestamp addedDate) throws SQLException {
        String query = "insert into Books (SN, Title, Author, Publisher, Price, Quantity, IssuedQTY, addedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, sn);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, publisher);
            pstmt.setDouble(5, price);
            pstmt.setInt(6, quantity);
            pstmt.setInt(7, issuedQTY);
            pstmt.setTimestamp(8, addedDate);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Added!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Reading from the Books table in database 
    public String readBooks() throws SQLException {
        String query = "SELECT * FROM Books";

        try (Connection con = connect();
             Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(query)) {

            ResultSetMetaData resultMD = result.getMetaData();

            StringBuilder bookData = new StringBuilder("<html><head><style>"
                    + "table {border-collapse: collapse;}"
                    + "th, td {border: 1px solid black; padding: 4px;}"
                    + "</style></head><body><table>");

            // Adding column headers
            bookData.append("<tr>");
            bookData.append("<th>Book ID</th>");
            bookData.append("<th>Title</th>");
            bookData.append("<th>Author</th>");
            bookData.append("<th>Publisher</th>");
            bookData.append("<th>Price</th>");
            bookData.append("<th>Quantity</th>");
            bookData.append("<th>Issued Quantity</th>");
            bookData.append("<th>Added Date</th>");
            bookData.append("</tr>");

            // Adding row data
            while (result.next()) {
                bookData.append("<tr>");

                for (int i = 1; i <= resultMD.getColumnCount(); i++) {
                    bookData.append("<td>").append(result.getString(i)).append("</td>");
                }

                bookData.append("</tr>");
            }
            bookData.append("</table></body></html>");

            System.out.println(bookData);
            return bookData.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // Delete
    public void deleteBook(String sn) throws SQLException {
        String query = "delete from books where sn = ?";

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, sn);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    // Update
    public void updateBook(String sn, String title, String author, String publisher, double price, int quantity, int issuedQTY, Timestamp addedDate) throws SQLException {
        String query = "update books set Title = ?, Author = ?, Publisher = ?, Price = ?, Quantity = ?, IssuedQTY = ?, addedDate = ? WHERE SN = ?";

        try (Connection con = connect();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, publisher);
            pstmt.setDouble(4, price);
            pstmt.setInt(5, quantity);
            pstmt.setInt(6, issuedQTY);
            pstmt.setTimestamp(7, addedDate);
            pstmt.setString(8, sn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean issueBook(String sn, int stid) throws SQLException {
        System.out.println("Reached issueBook");
        String queryBook = "select * from books where sn = ?";
        String queryStudent = "select * from Students where StudentId = ?";
        boolean issued = false;

        try (Connection con = connect();
             PreparedStatement pstmtBook = con.prepareStatement(queryBook);
             PreparedStatement pstmtStudent = con.prepareStatement(queryStudent)) {
            pstmtBook.setString(1, sn);
            pstmtStudent.setInt(1, stid);
            try (ResultSet resultBook = pstmtBook.executeQuery();
                 ResultSet resultStudent = pstmtStudent.executeQuery()) {

                if (resultBook.next() && resultStudent.next()) {
                    int quantity = resultBook.getInt("Quantity");
                    int issuedQTY = resultBook.getInt("IssuedQTY");

                    if (quantity > issuedQTY) {
                        int newIssuedQTY = issuedQTY + 1;
                        updateBook(sn, resultBook.getString("Title"), resultBook.getString("Author"), resultBook.getString("Publisher"), resultBook.getDouble("Price"), quantity, newIssuedQTY, resultBook.getTimestamp("addedDate"));
                        insertIssuedBooks(sn, stid, resultStudent.getString("Name"), resultStudent.getString("Contact"));
                        issued = true;
                        JOptionPane.showMessageDialog(null, "Succesfully Issued!");
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "All Books are Issued!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issued;
    }
    
    public boolean returnBook(String sn, int stid) throws SQLException {
        String queryIssuedBooks = "select * from IssuedBooks where sn = ? and stid = ?";
        String queryBook = "select * from Books where SN = ?";
        boolean returned = false;

        try (Connection con = connect();
            PreparedStatement pstmtIssuedBooks = con.prepareStatement(queryIssuedBooks);
            PreparedStatement pstmtBook = con.prepareStatement(queryBook)) {
            pstmtIssuedBooks.setString(1, sn);
            pstmtIssuedBooks.setInt(2, stid);

            try (ResultSet resultIssuedBooks = pstmtIssuedBooks.executeQuery()) {
                if (resultIssuedBooks.next()) {
                    int issuedBookId = resultIssuedBooks.getInt("id");
                    deleteIssuedBooks(issuedBookId);

                    pstmtBook.setString(1, sn);
                    try (ResultSet resultBook = pstmtBook.executeQuery()) {
                        if (resultBook.next()) {
                            int quantity = resultBook.getInt("Quantity");
                            int issuedQTY = resultBook.getInt("IssuedQTY");
                            int newIssuedQTY = issuedQTY - 1;

                            updateBook(sn, resultBook.getString("Title"), resultBook.getString("Author"), resultBook.getString("Publisher"), resultBook.getDouble("Price"), quantity, newIssuedQTY, resultBook.getTimestamp("addedDate"));
                            returned = true;
                            JOptionPane.showMessageDialog(null, "Succesfully Returned!");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returned;
    }
}
