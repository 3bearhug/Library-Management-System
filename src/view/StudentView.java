/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.ResourceBundle;
import model.Student;

/**
 *
 * @author Sunhwa Lee 
 */
public class StudentView {
    // Display students details 
    public void printStudentDetails(Student student, ResourceBundle messages) {
        System.out.println("Student Details:");
        System.out.println("ID: " + student.getStdId());
        System.out.println(messages.getString("student.name") + ": " + student.getName());
        System.out.println(messages.getString("student.phone") + ": " + student.getContactNumber());
    }
    
}
