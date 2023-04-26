/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import model.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.StudentView;

/**
 *
 * @author Sunhwa Lee 
 */
public class StudentControllerTest {
    
    Student model = new Student("2295484", "Amy", "438-880-1234");
    StudentView view = new StudentView();
    private StudentController instance;
    
    public StudentControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new StudentController(model, view);
        instance.setStudentID("1234");
        instance.setStudentName("Amy");
        instance.setStudentPhone("514");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setStudentID method, of class StudentController.
     */
    @Test
    public void testSetStudentID() {
        System.out.println("setStudentID");
        String id = "1234";
        instance.setStudentID(id);
    }

    /**
     * Test of getStudentID method, of class StudentController.
     */
    @Test
    public void testGetStudentID() {
        System.out.println("getStudentID");
        String expResult = "1234";
        String result = instance.getStudentID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStudentName method, of class StudentController.
     */
    @Test
    public void testSetStudentName() {
        System.out.println("setStudentName");
        String name = "Amy";
        instance.setStudentName(name);
    }

    /**
     * Test of getStudentName method, of class StudentController.
     */
    @Test
    public void testGetStudentName() {
        System.out.println("getStudentName");
        String expResult = "Amy";
        String result = instance.getStudentName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStudentPhone method, of class StudentController.
     */
    @Test
    public void testSetStudentPhone() {
        System.out.println("setStudentPhone");
        String phone = "514";
        instance.setStudentPhone(phone);
    }

    /**
     * Test of getStudentPhone method, of class StudentController.
     */
    @Test
    public void testGetStudentPhone() {
        System.out.println("getStudentPhone");
        String expResult = "514";
        String result = instance.getStudentPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateView method, of class StudentController.
     */
    @Test
    public void testUpdateView() {
        System.out.println("updateView");
        ResourceBundle messages = ResourceBundle.getBundle("i18n.ApplicationMessages_en_EN", Locale.ENGLISH);;
        instance.updateView(messages);
    }
    
}
