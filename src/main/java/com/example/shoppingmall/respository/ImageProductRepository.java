package com.example.shoppingmall.respository;

import com.example.shoppingmall.domain.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageProductRepository extends JpaRepository<ImageProduct,Long> {
}
