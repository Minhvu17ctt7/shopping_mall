package com.example.shoppingmall.respository;

import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByTitleContaining(String title);
    public Page<Product> findByTitleContaining(String title, Pageable page);
}
