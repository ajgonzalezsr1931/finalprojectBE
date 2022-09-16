package com.group4.finalproject.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group4.finalproject.entities.Products;
import com.group4.finalproject.services.ProductsServices;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductsController {
    private ProductsServices productsServices;
    @GetMapping("/all")
    public List<Products> getAll(){
        return productsServices.getAll();
    }
    @Transactional
  
    @PostMapping("/add")
    public void addProducts(@RequestBody Products product){
        productsServices.add( product);
    }
    @GetMapping("/get")
        public List<Products> findByTag(@RequestParam String tag){
            return productsServices.findByTags(tag);
        }

    @GetMapping("/get/{id}")
    public Products findById(@PathVariable Long id){
        return productsServices.findById(id);
    }

    @DeleteMapping("/delete/{id}")
        public void deleteById(@PathVariable Long id){
            productsServices.delete(id);
        }

    @PutMapping("/edit/{id}")
        public void editById(@PathVariable Long id,@RequestBody Products products){
            productsServices.editById(id,products);
        }
    }
    
    


