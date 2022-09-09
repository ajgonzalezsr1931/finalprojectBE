package com.group4.finalproject.services;

import java.util.List;

import com.group4.finalproject.entities.Products;

public interface ProductsServices {
    
     List<Products> getAll();

     void add(Products product);

     void remove(Products product);

     Products getUser(String email);

}
