package com.rudik.library.models;


import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@MappedSuperclass
public abstract class Person {
    @NotBlank(message = "Name must not be blank!")
    @Size(min = 5, message = "Name must be at least 5 characters long!")
    protected String name;

    protected Person() {}

    protected Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
}
