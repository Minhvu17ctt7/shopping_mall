package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.domain.Brand;
import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.respository.BrandRepository;
import com.example.shoppingmall.service.BrandService;
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
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public List<Brand> findAll(Sort sort) {
        return brandRepository.findAll(sort);
    }

    @Override
    public List<Brand> findAllById(Iterable<Long> iterable) {
        return brandRepository.findAllById(iterable);
    }

    @Override
    public <S extends Brand> List<S> saveAll(Iterable<S> iterable) {
        return brandRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        brandRepository.flush();
    }

    @Override
    public <S extends Brand> S saveAndFlush(S s) {
        return brandRepository.saveAndFlush(s);
    }

    @Override
    public <S extends Brand> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return brandRepository.saveAllAndFlush(iterable);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Brand> entities) {
        brandRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Brand> iterable) {
        brandRepository.deleteAllInBatch(iterable);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {
        brandRepository.deleteAllByIdInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        brandRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Brand getOne(Long aLong) {
        return brandRepository.getOne(aLong);
    }

    @Override
    public Brand getById(Long aLong) {
        return brandRepository.getById(aLong);
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example) {
        return brandRepository.findAll(example);
    }

    @Override
    public <S extends Brand> List<S> findAll(Example<S> example, Sort sort) {
        return brandRepository.findAll(example, sort);
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public <S extends Brand> S save(S s) {
        return brandRepository.save(s);
    }

    @Override
    public Optional<Brand> findById(Long aLong) {
        return brandRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return brandRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return brandRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        brandRepository.deleteById(aLong);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {
        brandRepository.deleteAllById(iterable);
    }

    @Override
    public void deleteAll(Iterable<? extends Brand> iterable) {
        brandRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }

    @Override
    public <S extends Brand> Optional<S> findOne(Example<S> example) {
        return brandRepository.findOne(example);
    }

    @Override
    public <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable) {
        return brandRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Brand> long count(Example<S> example) {
        return brandRepository.count(example);
    }

    @Override
    public <S extends Brand> boolean exists(Example<S> example) {
        return brandRepository.exists(example);
    }

    @Override
    public List<Brand> findByNameContaining(String name) {
        return brandRepository.findByNameContaining(name);
    }

    @Override
    public Page<Brand> findByNameContaining(String name, Pageable page) {
        return brandRepository.findByNameContaining(name, page);
    }
}
