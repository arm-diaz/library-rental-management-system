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
public class Book {
    
    protected String bookName;
    protected String bookAuthor;
    protected String bookISBN;
    
    public Book() {
        this.bookName = "none";
        this.bookAuthor = "none";
        this.bookISBN = "none";
    }
    
    public Book(String name, String author, String isbn) {
        this.bookName = name;
        this.bookAuthor = author;
        this.bookISBN = isbn;
    }
    
    public void setBookName(String name) {
        this.bookName = name;
    }
    
    public void setBookAuthor(String author){
        this.bookAuthor = author;
    }
    
    public void setISBN(String isbn) {
        this.bookISBN = isbn;
    }
    
    public String getBookName() {
        return this.bookName;
    }
    
    public String getBookAuthor() {
        return this.bookAuthor;
    }
    
    public String getISBN() {
        return this.bookISBN;
    }
    
    public void printBookInfo() {
        System.out.println("Book name: " + this.bookName);
        System.out.println("Book author: " + this.bookAuthor);
        System.out.println("Book ISBN: " + this.bookISBN);
    }
}
