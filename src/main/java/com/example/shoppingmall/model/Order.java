package com.example.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order implements Serializable {

    private int orderId;

    private Date orderDate;

    private int customerId;

    private double amount;

    private short status;
}
