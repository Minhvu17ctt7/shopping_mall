package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    List<Category> findAll(Sort sort);

    List<Category> findAllById(Iterable<Long> iterable);

    <S extends Category> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Category> S saveAndFlush(S s);

    <S extends Category> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Deprecated
    void deleteInBatch(Iterable<Category> entities);

    void deleteAllInBatch(Iterable<Category> iterable);

    void deleteAllByIdInBatch(Iterable<Long> iterable);

    @Deprecated
    Category getOne(Long aLong);

    Category getById(Long aLong);

    Page<Category> findAll(Pageable pageable);

    <S extends Category> S save(S s);

    Optional<Category> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Category category);

    void deleteAllById(Iterable<? extends Long> iterable);

    void deleteAll(Iterable<? extends Category> iterable);

    void deleteAll();

    <S extends Category> Optional<S> findOne(Example<S> example);

    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Category> long count(Example<S> example);

    <S extends Category> boolean exists(Example<S> example);

    List<Category> findByNameContaining(String name);

    Page<Category> findByNameContaining(String name, Pageable page);
}
