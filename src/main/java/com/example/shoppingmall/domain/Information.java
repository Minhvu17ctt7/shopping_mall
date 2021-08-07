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
@Table(name = "Informations")
public class Information implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long informationId;
    @Column(columnDefinition = "varchar(100) not null")
    private String Street;
    @Column(columnDefinition = "varchar(100) not null")
    private String City;
    @Column(nullable = false)
    private int zipcode;

//    @Column(nullable = false)
//    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
