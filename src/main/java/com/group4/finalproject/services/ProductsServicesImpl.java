package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

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

        return productsRepository.findAll();
    }

    @Override
    public void add(Products product) {
       productsRepository.save(product);
        
    }



    @Override
    public List<Products> findByTags(String tag) {
       
        return productsRepository.findByTags(tag);
    }

    @Override
    public void delete(Long id) {
        
        productsRepository.deleteById(id);
    }

    @Override
    public Products findById(Long id) {
        
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public void editById(Long id, Products products) {
        Products product = productsRepository.findById(id).orElse(null);
        product.setDescription(products.getDescription());
        product.setEmail(products.getEmail());
        product.setNameOfPiece(products.getNameOfPiece());
        product.setPrice(products.getPrice());
        product.setTags(products.getTags());
        product.setURL(products.getURL());
        
    }

   
    
}
