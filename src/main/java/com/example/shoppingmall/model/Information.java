package com.example.shoppingmall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information implements Serializable {
    private Long informationId;
    private String Street;
    private String City;
    private int zipcode;
}
