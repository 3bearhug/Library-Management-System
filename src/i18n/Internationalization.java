/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author USER
 */
public class Internationalization {
    
    public static void main(String[] args) {
        ResourceBundle bundleEN = ResourceBundle.getBundle("i18n.ApplicationMessages_en_EN", Locale.ENGLISH);
        ResourceBundle bundleFR = ResourceBundle.getBundle("i18n.ApplicationMessages_fr_FR", Locale.FRANCE);
        
        System.out.println("English Version");
        System.out.println(bundleEN.getString("book.title"));
        System.out.println(bundleEN.getString("book.author"));
        System.out.println(bundleEN.getString("student.name"));
        System.out.println(bundleEN.getString("student.phone"));
        System.out.println("\nFrench Version");
        System.out.println(bundleFR.getString("book.title"));
        System.out.println(bundleFR.getString("book.author"));
        System.out.println(bundleFR.getString("student.name"));
        System.out.println(bundleFR.getString("student.phone"));
    }
    
}
