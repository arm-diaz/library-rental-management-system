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
public class BookInventory extends Book{
    
    protected int bookQuantity;
    protected String lastUpdate;
    
    public BookInventory() {
        super();
        this.bookQuantity = 0;
        this.lastUpdate = "none";
    }
    
    public BookInventory(String name, String author, String isbn, int quantity, String updateDate) {
        this.bookName = name;
        this.bookAuthor = author;
        this.bookISBN = isbn;
        this.bookQuantity = quantity;
        this.lastUpdate = updateDate;
    }
    
    public void setBookQuantity(int quantity){
        this.bookQuantity = quantity;
    }
    
    public void setDateLastUpdated(String updateDate) {
        this.lastUpdate = updateDate;
    }
    
    public int getBookQuantity() {
        return this.bookQuantity;
    }
    
    public String getDateLastUpdated() {
        return this.lastUpdate;
    }
    
    @Override
    public void printBookInfo() {
         super.printBookInfo();
         System.out.println("Last book quantity: " + this.bookQuantity);
    }
    
    public void printBookInfoWithDate() {
        printBookInfo();
        System.out.println("Last updated date: " + this.lastUpdate);
    }
            
    
    
}
