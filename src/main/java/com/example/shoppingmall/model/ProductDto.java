package com.example.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {

    private Long productId;

    private String title;

    private int price;

    private int quantity;
    private String shortDescription;
    private String information;
    private String material;

    private Long categoryId;

    private Long brandingId;
}
