package com.example.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto implements Serializable {

    private Long productId;
    private String title;
    private int price;
    private int quantity;
    private String image;
    private MultipartFile imageFile;
    private String shortDescription;
    private String information;
    private String material;


    private Long categoryId;

    private Long brandId;
    private Boolean isEdit = false;
}
