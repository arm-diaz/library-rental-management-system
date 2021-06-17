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
public class Student extends User {
    private String faculty;
    private long phoneNum;
    
    public Student() {
        super();
        this.faculty = "none";
        this.phoneNum = 0000000000;
    }
    
    public Student(String major, long num){
        this.faculty = major;
        this.phoneNum = num;
    }
    
    public void setFaculty(String major) {
        this.faculty = major;
    }
    
    public void setPhoneNum(long num){
        this.phoneNum = num;
    }
    
    @Override
    public void printUserInfo(){
        super.printUserInfo();
        System.out.println("Faculty: " + this.faculty);
        System.out.println("Phone number: " + this.phoneNum);
    }
}
