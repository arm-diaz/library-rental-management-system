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
public class User {
    protected String name;
    protected String id;
    protected String email;
    protected String password;
    
    public User(){
       this.name = "none";
       this.id = "none";
       this.email = "none";
       this.password = "none";
    }
    
    public User(String usrName, String usrId, String UsrEmail, String usrPass){
       this.name = usrName;
       this.id = usrId;
       this.email = UsrEmail;
       this.password = usrPass;
    }
    
    public void setName(String usrName) {
        this.name = usrName;
    }
    
    public void setId(String usrId) {
        this.id = usrId;
    }
    
    public void setEmail(String UsrEmail) {
        this.email = UsrEmail;
    }
    
    public void setPassword(String usrPass) {
        this.password = usrPass;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void printUserInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Email: " + this.email);
    }
}
