package com.example.shoppingmall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(columnDefinition = "varchar(150) not null")
    private String title;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int quantity;
    private String shortDescription;
    private String information;
    private String material;


//    @Column(nullable = false)
//    private Long categoryId;
//    @Column(nullable = false)
//    private Long brandingId;
@ManyToOne
@JoinColumn(name = "categoryId")
private Category category;
    @ManyToOne
    @JoinColumn(name = "brandingId")
    private Brand brand;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Item> items;
}
