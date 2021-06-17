/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryInventory;

/**
 *
 * @author armandodiaz
 */
import java.util.ArrayList;

public class LoginSystem {
    
    ArrayList <Student> iAmStudent = new ArrayList<>();
    ArrayList <Librarian> iAmLibrarian = new ArrayList<>();
    
    public void newSignUpStudent(String name, String id, String email, String password, String faculty, long phone) {
        Student newStudent = new Student();
        
        newStudent.setName(name);
        newStudent.setId(id);
        newStudent.setEmail(email);
        newStudent.setPassword(password);
        newStudent.setFaculty(faculty);
        newStudent.setPhoneNum(phone);
        
        iAmStudent.add(newStudent);
    }
    
    public void newSignUpLibrarian(String name, String id, String email, String password, String position){
        Librarian newLibrarian = new Librarian();
        
        newLibrarian.setName(name);
        newLibrarian.setId(id);
        newLibrarian.setEmail(email);
        newLibrarian.setPassword(password);
        newLibrarian.setPosition(position);
        
        iAmLibrarian.add(newLibrarian);
        
        
    }
    
    public boolean signInStudent(String id, String password){
        boolean found = false;

        for (Student student : iAmStudent) {
            if (student.getId().equals(id)) {
                if (student.getPassword().equals(password)) {
                    System.out.println("\nWelcome " + student.getName());
                    found = true;
                } 
            }
        }
        return found;
    }
    
    public boolean signInLibrarian(String id, String password) {
        boolean found = false;

        for (Librarian librarian : iAmLibrarian) {
            if (librarian.getId().equals(id)) {
                if (librarian.getPassword().equals(password)) {
                    System.out.println("\nWelcome " + librarian.getName());
                    found = true;
                } else {
                    System.out.println("\nPlease enter the right id and password\n");
                }
            }
        }
        return found;
    }
    
    
    
    
    
}
