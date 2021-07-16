package com.example.soapexam.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private int quantity;
}
