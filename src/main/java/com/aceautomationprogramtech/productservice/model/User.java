package com.aceautomationprogramtech.productservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    // Getters and Setters
    public String getName() {
        return name;
    }
    // This method must exist
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    // This method must exist
    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and Setters
    public String getPassword() {
        return password;
    }
    // This method must exist
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
