package com.example.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    private Long itemId;
    private int productId;
    private String name;

    private int quanlity;

    private double unitPrice;
}

