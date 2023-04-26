/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import model.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import view.BookView;

/**
 *
 * @author Sunhwa Lee 
 */
public class BookControllerTest {
    
    Book model = new Book("B001", "Book1", "Author1", "publisher1", 10.0, 5, LocalDate.of(2021, 4, 15));
    BookView view = new BookView();
    private BookController instance;

    
    public BookControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new BookController(model, view);
        instance.setBookSN("1234");
        instance.setBookTitle("Java Programming");
        instance.setBookAuthor("John Doe");
        instance.setBookPublisher("ABC Publications");
        instance.setBookPrice(50.0);
        instance.setBookQuantity(10);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setBookSN method, of class BookController.
     */
    @Test
    public void testSetBookSN() {
        System.out.println("setBookSN");
        String sn = "1234";
        instance.setBookSN(sn);
    }


    /**
     * Test of setBookTitle method, of class BookController.
     */
    @Test
    public void testSetBookTitle() {
        System.out.println("setBookTitle");
        String title = "Java Programming";

        instance.setBookTitle(title);
    }

    /**
     * Test of setBookAuthor method, of class BookController.
     */
    @Test
    public void testSetBookAuthor() {
        System.out.println("setBookAuthor");
        String author = "John Doe";
        instance.setBookAuthor(author);
    }

    /**
     * Test of setBookPublisher method, of class BookController.
     */
    @Test
    public void testSetBookPublisher() {
        System.out.println("setBookPublisher");
        String publisher = "ABC Publications";
        instance.setBookPublisher(publisher);
    }

    /**
     * Test of setBookPrice method, of class BookController.
     */
    @Test
    public void testSetBookPrice() {
        System.out.println("setBookPrice");
        double price = 50.0;
        instance.setBookPrice(price);
    }

    /**
     * Test of setBookQuantity method, of class BookController.
     */
    @Test
    public void testSetBookQuantity() {
        System.out.println("setBookQuantity");
        int quantity = 10;
        instance.setBookQuantity(quantity);
    }

    /**
     * Test of getBookQuantity method, of class BookController.
     */
    @Test
    public void testGetBookQuantity() {
        System.out.println("getBookQuantity");
        int expResult = 10;
        int result = instance.getBookQuantity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBookIssuedQTY method, of class BookController.
     */
    @Test
    public void testSetBookIssuedQTY() {
        System.out.println("setBookIssuedQTY");
        int issuedQTY = 0;
        instance.setBookIssuedQTY(issuedQTY);
    }

    /**
     * Test of getBookIssuedQTY method, of class BookController.
     */
    @Test
    public void testGetBookIssuedQTY() {
        System.out.println("getBookIssuedQTY");
        int expResult = 0;
        int result = instance.getBookIssuedQTY();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateView method, of class BookController.
     */
    @Test
    public void testUpdateView() {
        System.out.println("updateView");
        ResourceBundle messages = ResourceBundle.getBundle("i18n.ApplicationMessages_en_EN", Locale.ENGLISH);;
        instance.updateView(messages);
    }
    
}
