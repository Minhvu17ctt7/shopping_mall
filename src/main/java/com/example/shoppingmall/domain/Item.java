package com.example.shoppingmall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    @Column(columnDefinition = "varchar(100) not null")
    private String name;
    @Column(nullable = false)
    private int quanlity;
    @Column(nullable = false)
    private double unitPrice;

//    @Column(nullable = false)
//    private Long productId;
//    @Column(nullable = false)
//    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}

