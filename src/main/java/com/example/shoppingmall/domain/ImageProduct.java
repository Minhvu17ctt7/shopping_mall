package com.example.shoppingmall.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ImageProducts")
public class ImageProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String image;

//    private Long productId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
