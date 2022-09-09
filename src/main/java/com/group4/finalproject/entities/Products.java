package com.group4.finalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nameOfPeice;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String tags;
    @Column(nullable = false)
    private String URL;

    public Products(String nameOfPeice, Long price, String description, String tags, String uRL) {
        this.nameOfPeice = nameOfPeice;
        this.price = price;
        this.description = description;
        this.tags = tags;
        URL = uRL;
    }
}
