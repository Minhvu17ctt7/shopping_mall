package com.example.shoppingmall.respository;

import com.example.shoppingmall.domain.Brand;
import com.example.shoppingmall.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    public List<Brand> findByNameContaining(String name);
    public Page<Brand> findByNameContaining(String name, Pageable page);
}
