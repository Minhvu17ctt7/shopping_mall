package com.example.shoppingmall.model;

import com.example.shoppingmall.domain.Information;
import com.example.shoppingmall.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private Long customerId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Date registeredDate;
    private short status;
    private String avatar;
    private MultipartFile imageFile;
    private String rule;

}