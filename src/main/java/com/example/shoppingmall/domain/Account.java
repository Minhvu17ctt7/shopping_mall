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
@Table(name = "Acounts")
public class Account implements Serializable {
    @Id
    @Column(length = 30)
    private String username;
    @Column(length = 30, nullable = false)
    private String password;
}
