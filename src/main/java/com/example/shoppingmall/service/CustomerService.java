package com.example.shoppingmall.service;

import com.example.shoppingmall.domain.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    List<Customer> findAll(Sort sort);

    List<Customer> findAllById(Iterable<Long> iterable);

    <S extends Customer> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends Customer> S saveAndFlush(S s);

    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> iterable);

    @Deprecated
    void deleteInBatch(Iterable<Customer> entities);

    void deleteAllInBatch(Iterable<Customer> iterable);

    void deleteAllByIdInBatch(Iterable<Long> iterable);

    void deleteAllInBatch();

    @Deprecated
    Customer getOne(Long aLong);

    Customer getById(Long aLong);

    <S extends Customer> List<S> findAll(Example<S> example);

    <S extends Customer> List<S> findAll(Example<S> example, Sort sort);

    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Customer customer);

    void deleteAllById(Iterable<? extends Long> iterable);

    void deleteAll(Iterable<? extends Customer> iterable);

    void deleteAll();

    <S extends Customer> Optional<S> findOne(Example<S> example);

    <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Customer> long count(Example<S> example);

    <S extends Customer> boolean exists(Example<S> example);
}
