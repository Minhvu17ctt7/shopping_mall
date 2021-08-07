package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Brand;
import com.example.shoppingmall.domain.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    List<Brand> findAll();

    List<Brand> findAll(Sort sort);

    List<Brand> findAllById(Iterable<Long> iterable);

    <S extends Brand> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Brand> S saveAndFlush(S s);

    <S extends Brand> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Deprecated
    void deleteInBatch(Iterable<Brand> entities);

    void deleteAllInBatch(Iterable<Brand> iterable);

    void deleteAllByIdInBatch(Iterable<Long> iterable);

    void deleteAllInBatch();

    @Deprecated
    Brand getOne(Long aLong);

    Brand getById(Long aLong);

    <S extends Brand> List<S> findAll(Example<S> example);

    <S extends Brand> List<S> findAll(Example<S> example, Sort sort);

    Page<Brand> findAll(Pageable pageable);

    <S extends Brand> S save(S s);

    Optional<Brand> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Brand brand);

    void deleteAllById(Iterable<? extends Long> iterable);

    void deleteAll(Iterable<? extends Brand> iterable);

    void deleteAll();

    <S extends Brand> Optional<S> findOne(Example<S> example);

    <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Brand> long count(Example<S> example);

    <S extends Brand> boolean exists(Example<S> example);

    List<Brand> findByNameContaining(String name);

    Page<Brand> findByNameContaining(String name, Pageable page);
}
