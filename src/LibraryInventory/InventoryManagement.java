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
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagement {
    
   //private String newBookName;
   //private String newBookAuthor;
   //private String newBookISBN;
   //private int newBookQuantity;
   //private String newBookDate;
   
   private ArrayList <BookInventory> libraryBooks;
   
   
   public InventoryManagement() {
       this.libraryBooks = new ArrayList <BookInventory>();
       BookInventory a = new BookInventory("Golden Girl", "Elin Hilderbrand", "978", 10, "Jun 12, 2021");
       BookInventory b = new BookInventory("Golden Girl", "Taylor Jenkins Reid", "456", 9, "Jun 12, 2021");
       BookInventory c = new BookInventory("The Last Thing He Told Me", "Laura Dave", "789", 8,"Jun 12, 2021");
       BookInventory d = new BookInventory("Sooley", "John Grisham", "1011", 7, "Jun 12, 2021");
       BookInventory e = new BookInventory("Atomic Habits", "James Clear", "1012", 6, "Jun 12, 2021");
       BookInventory f = new BookInventory("The Four Winds", "Kristin Hannah", "1013", 5, "Jun 12, 2021");
       BookInventory g = new BookInventory("The Midnight Library", "Matt Haig", "1014", 4, "Jun 12, 2021");
       BookInventory h = new BookInventory("We Were Liars", "E. Lockhart", "1015", 3, "Jun 12, 2021");
       BookInventory j = new BookInventory("Greenlights", "Matthew McConaughey", "1016", 2, "Jun 12, 2021");
       BookInventory k = new BookInventory("How the Word Is Passed", "Clint Smith", "1017", 0, "Jun 12, 2021");
       
       libraryBooks.add(a);
       libraryBooks.add(b);
       libraryBooks.add(c);
       libraryBooks.add(d);
       libraryBooks.add(e);
       libraryBooks.add(f);
       libraryBooks.add(g);
       libraryBooks.add(h);
       libraryBooks.add(j);
       libraryBooks.add(k);
     
       
   }
   
   
   public void addNewBook(String newBookName, String newBookAuthor, 
                          String newBookISBN, int newBookQuantity,
                          String newBookDate) {
       
      BookInventory newBook = new BookInventory(newBookName, newBookAuthor,
                                                newBookISBN, newBookQuantity,
                                                newBookDate);

      this.libraryBooks.add(newBook);
      System.out.println("\n\"" + newBookName + "\" is successfully added to the inventody.");
   }
   
   public void deleteBook(String bIsbn) {
       boolean found = false;
       String foundBook;
       
       for (int i = 0; i < libraryBooks.size(); ++i) {
           if (libraryBooks.get(i).getISBN().equals(bIsbn)){
               foundBook = libraryBooks.get(i).getBookName();
               System.out.println("\n\"" + foundBook + "\" successfully deleted.");
               libraryBooks.remove(i);
               found = true;
           }
       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory. Nothing removed.");
       }
   }
   
   public void updateDate(String bIsbn, String newDate) {
       boolean found = false;
       String foundDate;
       
       for (int i = 0; i < libraryBooks.size(); ++i) {
           if (libraryBooks.get(i).getISBN().equals(bIsbn)){
               foundDate = libraryBooks.get(i).getDateLastUpdated();
               System.out.println("\nDate changed from \"" + foundDate + "\" to \"" + newDate + "\".");
               libraryBooks.get(i).setDateLastUpdated(newDate);
               found = true;
           }
       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory. Date is not updated.");
       }
   }
   
   public void updateQuantity(String bIsbn, int bQuantity) {
       boolean found = false;
       String foundbook;
       
       for (int i = 0; i < libraryBooks.size(); ++i) {
           if (libraryBooks.get(i).getISBN().equals(bIsbn)){
               foundbook = libraryBooks.get(i).getBookName();
               libraryBooks.get(i).setBookQuantity(bQuantity);
               
               System.out.println("\nThe quantity of \"" + foundbook + "\" is changed to " + bQuantity + ".");
               found = true;
           }
       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory. Quantity is not updated.");
       }
   }
   
   public boolean searchFirst(String bName) {
       int order = 0;
       boolean searchResult = false;

       for (BookInventory libraryBook : this.libraryBooks) {
           if (libraryBook.getBookName().equals(bName)) {
               System.out.println();
               ++ order;
               System.out.println(order + ".");
               libraryBook.printBookInfo();
               //System.out.println();
               searchResult = true;
           }
       }
       
       if(searchResult == false) {
           System.out.println("\nThe book not found in the inventory.");

       }
       return searchResult;
   }

   
   public void rentBook(String bIsbn) {
       boolean found = false;
       String foundbook;
       int leftBookQty;

       for (BookInventory libraryBook : this.libraryBooks) {
           if (libraryBook.getISBN().equals(bIsbn)) {
               leftBookQty = libraryBook.getBookQuantity();
               foundbook = libraryBook.getBookName();
               if (leftBookQty > 0) {
                   leftBookQty = leftBookQty - 1;
                   libraryBook.setBookQuantity(leftBookQty);

                   System.out.println("\nRented Book :" + foundbook + "\nYour due date for return is 7 days from today.");
                   found = true;
               }
               else if(leftBookQty <= 0){
                   System.out.println("\nThe book \""+ foundbook + "\" is out of stock. It is invalid for rent.");
                   found = true;
               }
           }
       }
       if (!found) {
           System.out.println("\nThe book not found in the inventory.");
       }
   }
   
      public void returnBook(String bIsbn) {
       boolean found = false;
       String foundbook;
       int leftBookQty;
       
       for (BookInventory libraryBook : this.libraryBooks) {
              if (libraryBook.getISBN().equals(bIsbn)) {
                  foundbook = libraryBook.getBookName();
                  leftBookQty = libraryBook.getBookQuantity();
                  leftBookQty = leftBookQty + 1;
                  libraryBook.setBookQuantity(leftBookQty);

                  System.out.println("\nThe book \"" + foundbook + "\" is successfully returned.");
                  found = true;
              }
       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory.");
       }
   }
   
   public void printForStudent(String bName) {
       int order = 0;
       boolean found = false;
       
       
       for (BookInventory libraryBook : this.libraryBooks) {
           if (libraryBook.getBookName().equals(bName)) {
               System.out.println();
               ++ order;
               System.out.println(order + ".");
               libraryBook.printBookInfo();
               found = true;
           }

       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory.");
           
       }
   }
   
   public void printForLibrarian(String bName) {
       int order = 0;
       boolean found = false;
       
       
       
       for (BookInventory libraryBook : this.libraryBooks) {
           if (libraryBook.getBookName().equals(bName)) {
               System.out.println();
               ++ order;
               System.out.println(order + ".");
               libraryBook.printBookInfoWithDate();
               found = true;
           }

       }
       if (found == false) {
           System.out.println("\nThe book not found in the inventory.");
           
       }
   }
  
}
