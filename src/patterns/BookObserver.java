/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patterns;

import model.Book;

/**
 *
 * @author Sunhwa Lee 
 */

// since this is interface, update availability method is abstract. call BookObserver interface when book's availability changed 
public interface BookObserver {
    void updateAvailability(Book book);
}

