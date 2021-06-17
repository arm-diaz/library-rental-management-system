package LibraryInventory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import LibraryInventory.LoginSystem;
import LibraryInventory.InventoryManagement;
import java.lang.NumberFormatException;


/**
 *
 * @author scarlettpark, armandodiaz
 */

public class CSCI325 {

    private Character userType;
    
    public void printMenu() {
        System.out.println("\nMENU");
        System.out.println("You must sign up first before trying to login");
        System.out.println("s - Sign up into the system");
        System.out.println("l - Login into the system");
        //System.out.println("t - Search book");
        System.out.println("q - Quit\n");
       
    }

    public void printInventoryLibrarian() {
        System.out.println("\nMENU");
        System.out.println("a - Add book");
        System.out.println("d - Remove book");
        System.out.println("u - Edit last updated date");
        System.out.println("c - Update quantity");
        System.out.println("t - Search book by name");
        System.out.println("q - Quit\n");

    }

    public void printInventoryStudent() {
        System.out.println("MENU");
        System.out.println("r - Rent book");
        System.out.println("g - Return book");
        System.out.println("t - Search book by name");
        System.out.println("q - Quit\n");

    }

    public void executeInventory(Scanner scnr, CSCI325 myLibrary, LoginSystem myLoginSystem, InventoryManagement myInventory){

        if (Character.toString(this.userType).equals("s")){
            // Print menu
            myLibrary.printInventoryStudent();
            System.out.println("Choose an option:");
            char choice = scnr.nextLine().charAt(0);

            while (choice != 'q') {
                if (choice == 'r'){
                    String rentBookIsbn;
                    String rentBookName;
                    System.out.println("Enter book name to rent:");
                    rentBookName = scnr.nextLine();
                    boolean resultRent = myInventory.searchFirst(rentBookName);
                    
                    if(resultRent == true) {
                        System.out.println("Enter book's ISBN to rent:");
                        rentBookIsbn = scnr.nextLine();
                        myInventory.rentBook(rentBookIsbn);
                    }


                } else if (choice == 'g'){
                    String returnBookIsbn;
                    String returnBookName;
                    System.out.println("Enter book name to return:");
                    returnBookName = scnr.nextLine();
                    boolean resultReturn = myInventory.searchFirst(returnBookName);
                    
                    if(resultReturn == true) {
                       System.out.println("Enter book's ISBN to return:");
                       returnBookIsbn = scnr.nextLine();
                       myInventory.returnBook(returnBookIsbn);
                    }

                } else if (choice == 't'){
                    String searchBookName;
                    System.out.println("Enter book's name:");
                    searchBookName = scnr.nextLine();
                    myInventory.printForStudent(searchBookName);
                }
                System.out.println();
                myLibrary.printInventoryStudent();
                System.out.println("Choose an option:");
                choice = scnr.nextLine().charAt(0);

            }

        } else if (Character.toString(this.userType).equals("b")) {
            // Print menu
            myLibrary.printInventoryLibrarian();
            System.out.println("\nChoose an option:");
            char choice = scnr.nextLine().charAt(0);

            while (choice != 'q') {
                if (choice == 'a'){
                    // Parameters
                    String addBookName;
                    String addBookAuthor;
                    String addBookISBN;
                    int addBookQuantity = 0;
                    String addBookDate;

                    System.out.println("Enter book's name:");
                    addBookName = scnr.nextLine();
                    System.out.println("Enter book's author:");
                    addBookAuthor = scnr.nextLine();
                    System.out.println("Enter book's ISBN:");
                    addBookISBN = scnr.nextLine();
                    System.out.println("Enter book's quantity:");
                    boolean intError = true;
                    do {
                        try{
                            addBookQuantity = Integer.parseInt(scnr.nextLine());
                            intError = false;
                        } catch(NumberFormatException e){
                            System.out.println("Invalid data type: Please enter a number for quantity.");
                            System.out.println("Enter book's quantity again:");
                            scnr.reset();
                        }


                    } while (intError);

                    System.out.println("Enter book's creation date(e.g. Feb 13, 2021):");
                    addBookDate = scnr.nextLine();

                    myInventory.addNewBook(addBookName, addBookAuthor, addBookISBN, addBookQuantity, addBookDate);

                } else if (choice == 'd'){
                    String removeBookIsbn;
                    String removeBookName;
                    boolean resultRemove;
                    
                    System.out.println("Enter book name to remove:");
                    removeBookName = scnr.nextLine();
                    resultRemove = myInventory.searchFirst(removeBookName);
                    
                    if (resultRemove == true){
                       System.out.println("\nEnter book's ISBN to remove:");
                       removeBookIsbn = scnr.nextLine();

                       myInventory.deleteBook(removeBookIsbn);
                    }   

                } else if (choice == 'u'){
                    String updateBookDIsbn;
                    String updateBookDate;
                    String updateBookName;
                    boolean resultDate;
                    
                    System.out.println("Enter book name to update the date:");
                    updateBookName = scnr.nextLine();
                    resultDate = myInventory.searchFirst(updateBookName);
                    if (resultDate == true) {
                       System.out.println("\nEnter book's ISBN to update the date:");
                       updateBookDIsbn = scnr.nextLine();
                       System.out.println("Enter book's new last updated date:");
                       updateBookDate = scnr.nextLine();

                       myInventory.updateDate(updateBookDIsbn, updateBookDate);
                    }
                    

                } else if (choice == 'c'){
                    String updateBookQIsbn;
                    int updateBookQuantity = 0;
                    String updateQtyBookName;
                    boolean resultQty;
                    
                    System.out.println("Enter book name to update the quantity:");
                    updateQtyBookName = scnr.nextLine();
                    resultQty = myInventory.searchFirst(updateQtyBookName);
                    if(resultQty == true) {
                       System.out.println("\nEnter book's ISBN to update the quantity:");
                       updateBookQIsbn = scnr.nextLine();
                       System.out.println("Enter book's new quantity:");
                        boolean intError = true;
                        do {
                            try{
                                updateBookQuantity = Integer.parseInt(scnr.nextLine());
                                intError = false;
                            } catch(NumberFormatException e){
                                System.out.println("Invalid data type: Please enter a number for new quantity.");
                                System.out.println("Enter book name to update the quantity again:");
                                scnr.reset();
                            }

                        } while (intError);

                    myInventory.updateQuantity(updateBookQIsbn, updateBookQuantity);
                        
                    }

                }  else if (choice == 't'){
                    String searchBookName;
                    System.out.println("Enter book's name:");
                    searchBookName = scnr.nextLine();
                    myInventory.printForLibrarian(searchBookName);
                }
                myLibrary.printInventoryLibrarian();
                System.out.println("Choose an option:");
                choice = scnr.nextLine().charAt(0);

            }

        } else {
            System.out.println("Invalid. Please try it again.");
        }


    }

    public void printSignUp(){
        // System.out.println("\nMENU");
        System.out.println("s - Are you a student?");
        System.out.println("b - Are you a librarian?");
    }

    public void executeSignUp(Scanner scnr, LoginSystem myLoginSystem){
        // Parameters
        String name;
        String id;
        String email;
        String password;
        String faculty;
        long phone = 0;
        String position;

        if (Character.toString(userType).matches("[s|b]")) {
            // System.out.println("Student: " + userType);
            System.out.println("Enter your name:");
            name = scnr.nextLine();
            System.out.println("Enter your id:");
            id = scnr.nextLine();
            System.out.println("Enter your email:");
            email = scnr.nextLine();
            System.out.println("Enter your password:");
            password = scnr.nextLine();

            if (Character.toString(this.userType).equals("s")){
                System.out.println("Enter your major's name:");
                faculty = scnr.nextLine();
                System.out.println("Enter your phone:");
                boolean longError = true;
                do {
                    try{
                        phone = Long.parseLong(scnr.nextLine());
                        longError = false;
                    } catch(NumberFormatException e){
                        System.out.println("Invalid data type: Please enter number for phone number.");
                        System.out.println("Enter your phone again:");
                        scnr.reset();
                    }

                } while (longError);

                myLoginSystem.newSignUpStudent(name, id, email, password, faculty, phone);

            } else if (Character.toString(this.userType).equals("b")) {
                //System.out.println("Library: " + this.userType);
                System.out.println("Enter your position in the library:");
                position = scnr.nextLine();
                myLoginSystem.newSignUpLibrarian(name, id, email, password, position);

            }

            System.out.println("\nSign up is done. Now you can login using your account.");
        }
        else {
            System.out.println("Invalid. Please try it again and choose a valid option");

        }


    }

    public void executeSigIn(Scanner scnr, CSCI325 myLibrary, LoginSystem myLoginSystem, InventoryManagement myInventory){
        String id;
        String password;
        System.out.println("Enter your id:");
        id = scnr.nextLine();
        System.out.println("Enter your password:");
        password = scnr.nextLine();
        boolean isUserOn;
        
        // Print menu
        
        if (this.userType == null) {
            System.out.println("\nInvalid user. Please enter the right id and password.\n"
                               + "If you haven't signed up, please sign up first.");
        }
        
        if (this.userType != null){
            if (Character.toString(this.userType).equals("s")){
               isUserOn = myLoginSystem.signInStudent(id, password);
               if (isUserOn == true) {
                  myLibrary.executeInventory(scnr, myLibrary, myLoginSystem, myInventory);
               }
               else {
                   System.out.println("\nInvalid user. Please enter the right id and password.\n"
                               + "If you haven't signed up, please sign up first.");
                   
               }

            }   
            else if (Character.toString(this.userType).equals("b")) {
               isUserOn = myLoginSystem.signInLibrarian(id, password);
               if (isUserOn == true) {
                  myLibrary.executeInventory(scnr, myLibrary, myLoginSystem, myInventory);
               }
               else {
               System.out.println("\nInvalid user. Please enter the right id and password.\n"
                               + "If you haven't signed up, please sign up first.");
               }
            } 
       }
    }
            

    public void executeMenu(char choice, Scanner scnr, CSCI325 myLibrary, LoginSystem myLoginSystem, InventoryManagement myInventory) {

        switch (choice) {
            case 'q':
                System.exit(0);

            case 'l':
                myLibrary.executeSigIn(scnr, myLibrary, myLoginSystem,myInventory);
                break;

            case 's':
                // Print menu
                myLibrary.printSignUp();
                System.out.println("\nChoose an option:");
                boolean inputError = true;
                // Read user choice
                do {
                    try{
                        this.userType = scnr.nextLine().charAt(0);
                        if (!Character.toString(userType).matches("[s|b]")) {
                            throw new Exception("Invalid. Please try it again and choose a valid option");
                        }
                        inputError = false;
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                        myLibrary.printSignUp();
                        System.out.println("\nChoose an option:");
                        scnr.reset();
                    }

                } while (inputError);

                myLibrary.executeSignUp(scnr, myLoginSystem);
                break;

            //case 't':
               // myLibrary.executeInventory(scnr, myLibrary, myLoginSystem, myInventory);
                //break;
        }
    }
    
    public static void main(String[] args) {
        // Parameters
        char choice;

        System.out.println("Welcome to the library, CS325!");
        CSCI325 myLibrary = new CSCI325();
        LoginSystem myLoginSystem = new LoginSystem();
        InventoryManagement searchInvent = new InventoryManagement();


        // Print menu
        myLibrary.printMenu();
        System.out.println("Choose an option:");

        Scanner scnr = new Scanner(System.in);

        // Read user choice
        choice = scnr.nextLine().charAt(0);

        while (choice != 'q') {
            myLibrary.executeMenu(choice, scnr, myLibrary, myLoginSystem, searchInvent);
            myLibrary.printMenu();
            System.out.println("Choose an option:");
            choice = scnr.nextLine().charAt(0);
        }
        if( choice == 'q') {
            System.out.println("\nGood Bye.");
        }

    }
}
