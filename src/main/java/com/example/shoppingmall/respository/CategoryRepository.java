package com.example.shoppingmall.respository;

import com.example.shoppingmall.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findByNameContaining(String name);
    public Page<Category> findByNameContaining(String name, Pageable page);
}
