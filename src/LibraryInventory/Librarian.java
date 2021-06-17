/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryInventory;

/**
 *
 * @author scarlettpark
 */
public class Librarian extends User{
    private String position;
    
    public Librarian() {
        super();
        this.position = "none";
    }
    
    public Librarian(String libPosition) {
        this.position = libPosition;
    }
    
    public void setPosition(String libPosition){
        this.position = libPosition;
    }
    
    public String getPosition(String libPosition){
        return this.position;
    }
    
    @Override
    public void printUserInfo() {
        super.printUserInfo();
        System.out.println("Position: " + this.position);
        
    }
}
