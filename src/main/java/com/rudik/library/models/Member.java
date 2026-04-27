package com.rudik.library.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Member extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Email should not be blank!")
    @Email(message = "Incorrect email!")
    private String email;

    @Min(value = 0, message = "Balance must be greater than 0!")
    private double balance = 0;

    protected Member() {}

    public Member(String name, String email){
        super(name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nEmail: " + email;
    }
}
