package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Products editById(Long id, Products products) {
        Optional<Products>product = productsRepository.findById(id);
        if(!product.isPresent()){
            return null;
        }
        Products productsUpdate = product.get();
        if(products.getDescription() != null){
            productsUpdate.setDescription(products.getDescription());
        }
       if(products.getEmail() != null){
        productsUpdate.setEmail(products.getEmail());
        }
        if(products.getNameOfPiece() != null){
        productsUpdate.setNameOfPiece(products.getNameOfPiece());
        }
        if(products.getPrice() != null){
        productsUpdate.setPrice(products.getPrice());
        }
        if(products.getTags() != null){
            productsUpdate.setTags(products.getTags());
        }
        if(products.getURL() != null){
            productsUpdate.setURL(products.getURL());
        }
       return productsUpdate;
       
        
        
        
    }

   
    
}
