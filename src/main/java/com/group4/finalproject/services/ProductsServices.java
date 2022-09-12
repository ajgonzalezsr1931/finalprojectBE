package com.group4.finalproject.services;

import java.util.List;

import com.group4.finalproject.entities.Products;

public interface ProductsServices {

     List<Products> getAll();

     void add(Products product);


    List<Products> findByTags(String tag);

    void delete(Long id);

    Products findById(Long id);

    Products editById(Long id, Products products); 

}
