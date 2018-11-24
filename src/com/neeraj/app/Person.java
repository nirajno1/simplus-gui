/**
 * com.neeraj.app Person.java
 * @author Neeraj Kumar
 * @since Nov 24, 201811:07:21 AM	
 */
package com.neeraj.app;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Copyright Holiday-Factory
 * com.neeraj.app 
 * Person.java
 * @author Neeraj Kumar
 * @since Nov 24, 2018 11:07:21 AM	
 */
public class Person {
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
 
    public Person(String fName, String lName, String email) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.email = new SimpleStringProperty(email);
    }
 
    public String getFirstName() {
        return firstName.get();
    }
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String fName) {
        email.set(fName);
    }
    
 
}