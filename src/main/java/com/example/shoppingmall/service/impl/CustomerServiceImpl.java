package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.domain.Customer;
import com.example.shoppingmall.respository.CustomerRepository;
import com.example.shoppingmall.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return customerRepository.findAll(sort);
    }

    @Override
    public List<Customer> findAllById(Iterable<Long> iterable) {
        return customerRepository.findAllById(iterable);
    }

    @Override
    public <S extends Customer> List<S> saveAll(Iterable<S> iterable) {
        return customerRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        customerRepository.flush();
    }

    @Override
    public <S extends Customer> S saveAndFlush(S s) {
        return customerRepository.saveAndFlush(s);
    }

    @Override
    public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return customerRepository.saveAllAndFlush(iterable);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Customer> entities) {
        customerRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Customer> iterable) {
        customerRepository.deleteAllInBatch(iterable);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {
        customerRepository.deleteAllByIdInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Customer getOne(Long aLong) {
        return customerRepository.getOne(aLong);
    }

    @Override
    public Customer getById(Long aLong) {
        return customerRepository.getById(aLong);
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example) {
        return customerRepository.findAll(example);
    }

    @Override
    public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
        return customerRepository.findAll(example, sort);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public <S extends Customer> S save(S s) {
        return customerRepository.save(s);
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return customerRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {
        customerRepository.deleteAllById(iterable);
    }

    @Override
    public void deleteAll(Iterable<? extends Customer> iterable) {
        customerRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public <S extends Customer> Optional<S> findOne(Example<S> example) {
        return customerRepository.findOne(example);
    }

    @Override
    public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return customerRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Customer> long count(Example<S> example) {
        return customerRepository.count(example);
    }

    @Override
    public <S extends Customer> boolean exists(Example<S> example) {
        return customerRepository.exists(example);
    }
}
