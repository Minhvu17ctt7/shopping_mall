package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAll(Sort sort);

    List<Product> findAllById(Iterable<Long> iterable);

    <S extends Product> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Product> S saveAndFlush(S s);

    <S extends Product> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Deprecated
    void deleteInBatch(Iterable<Product> entities);

    void deleteAllInBatch(Iterable<Product> iterable);

    void deleteAllByIdInBatch(Iterable<Long> iterable);

    void deleteAllInBatch();

    @Deprecated
    Product getOne(Long aLong);

    Product getById(Long aLong);

    <S extends Product> List<S> findAll(Example<S> example);

    <S extends Product> List<S> findAll(Example<S> example, Sort sort);

    Page<Product> findAll(Pageable pageable);

    <S extends Product> S save(S s);

    Optional<Product> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Product product);

    void deleteAllById(Iterable<? extends Long> iterable);

    void deleteAll(Iterable<? extends Product> iterable);

    void deleteAll();

    <S extends Product> Optional<S> findOne(Example<S> example);

    <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Product> long count(Example<S> example);

    <S extends Product> boolean exists(Example<S> example);



    List<Product> findByTitleContaining(String title);

    Page<Product> findByTitleContaining(String title, Pageable page);
}
