package com.group4.finalproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.finalproject.entities.Products;
import com.group4.finalproject.services.ProductsServices;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")

public class ProductsController {
    private ProductsServices productsServices;
    @GetMapping("/all")
    public List<Products> getAll(){
        return productsServices.getAll();
    }
    @PostMapping("/add")
    public void addProducts(@RequestBody Products product){
        productsServices.add( product);
    }
    

}
