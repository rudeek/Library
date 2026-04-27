package com.rudik.library.services;

public interface Manageable <T>{
    void add(T element);
    void remove(int id);
    T findById(int id);
}
