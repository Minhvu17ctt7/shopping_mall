package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.domain.Product;
import com.example.shoppingmall.respository.ProductRepository;
import com.example.shoppingmall.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    @Override
    public List<Product> findAllById(Iterable<Long> iterable) {
        return productRepository.findAllById(iterable);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
        return productRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        productRepository.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S s) {
        return productRepository.saveAndFlush(s);
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return productRepository.saveAllAndFlush(iterable);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Product> entities) {
        productRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> iterable) {
        productRepository.deleteAllInBatch(iterable);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {
        productRepository.deleteAllByIdInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        productRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Product getOne(Long aLong) {
        return productRepository.getOne(aLong);
    }

    @Override
    public Product getById(Long aLong) {
        return productRepository.getById(aLong);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return productRepository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return productRepository.findAll(example, sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public <S extends Product> S save(S s) {
        return productRepository.save(s);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return productRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {
        productRepository.deleteAllById(iterable);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {
        productRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return productRepository.findOne(example);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return productRepository.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return productRepository.exists(example);
    }
}
