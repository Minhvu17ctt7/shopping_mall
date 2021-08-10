package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.ImageProduct;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ImageProductService {
    List<ImageProduct> findAll();

    List<ImageProduct> findAll(Sort sort);

    List<ImageProduct> findAllById(Iterable<Long> iterable);

    <S extends ImageProduct> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ImageProduct> S saveAndFlush(S s);

    <S extends ImageProduct> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Deprecated
    void deleteInBatch(Iterable<ImageProduct> entities);

    void deleteAllInBatch(Iterable<ImageProduct> iterable);

    void deleteAllByIdInBatch(Iterable<Long> iterable);

    void deleteAllInBatch();

    @Deprecated
    ImageProduct getOne(Long aLong);

    ImageProduct getById(Long aLong);

    <S extends ImageProduct> List<S> findAll(Example<S> example);

    <S extends ImageProduct> List<S> findAll(Example<S> example, Sort sort);

    Page<ImageProduct> findAll(Pageable pageable);

    <S extends ImageProduct> S save(S s);

    Optional<ImageProduct> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(ImageProduct imageProduct);

    void deleteAllById(Iterable<? extends Long> iterable);

    void deleteAll(Iterable<? extends ImageProduct> iterable);

    void deleteAll();

    <S extends ImageProduct> Optional<S> findOne(Example<S> example);

    <S extends ImageProduct> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ImageProduct> long count(Example<S> example);

    <S extends ImageProduct> boolean exists(Example<S> example);
}
