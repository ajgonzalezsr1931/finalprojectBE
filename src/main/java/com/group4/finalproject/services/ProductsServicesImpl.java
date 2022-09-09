package com.group4.finalproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group4.finalproject.entities.Products;
import com.group4.finalproject.repositories.ProductsRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductsServicesImpl implements ProductsServices {

    private final ProductsRepository productsRepository;
    @Override
    public List<Products> getAll() {
        // TODO Auto-generated method stub
        return productsRepository.findAll();
    }

    @Override
    public void add(Products product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(Products product) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Products getUser(String email) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
