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
public class Customer implements Serializable {
    private int customerId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date registeredDate;
    private short status;
    private Long informationId;
}