/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ResourceBundle;
import model.Book;
import model.Student;
import view.StudentView;

/**
 *
 * @author Sunhwa Lee 
 */
public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentID(String id) {
        model.setStdId(id);
    }

    public String getStudentID() {
        return model.getStdId();
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentPhone(String phone) {
        model.setContactNumber(phone);
    }

    public String getStudentPhone() {
        return model.getContactNumber();
    }

    public boolean borrowBook(Book book) {
        return model.borrow(book);
    }

    public boolean returnBook(Book book) {
        return model.toReturn(book);
    }
    
    // Updates the view to display the details of the student    
    public void updateView(ResourceBundle messages) {
        view.printStudentDetails(model, messages);
    }
}

