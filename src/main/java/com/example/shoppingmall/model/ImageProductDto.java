package com.example.shoppingmall.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ImageProducts")
public class ImageProductDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String image;

    private Long productId;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private Set<Product> listProduct;
}
