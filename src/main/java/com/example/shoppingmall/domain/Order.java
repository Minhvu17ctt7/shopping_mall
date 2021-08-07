package com.example.shoppingmall.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(nullable = false)
    private int itemId;
    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private short status;

//    @Column(nullable = false)
//    private Long customerId;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<Item> listItem;
}
