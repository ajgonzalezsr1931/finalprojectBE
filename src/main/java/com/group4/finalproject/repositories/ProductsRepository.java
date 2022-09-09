package com.group4.finalproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.finalproject.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    

   List<Products> findByTags(String tag);
}
