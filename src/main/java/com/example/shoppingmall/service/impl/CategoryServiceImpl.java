package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.domain.Category;
import com.example.shoppingmall.respository.CategoryRepository;
import com.example.shoppingmall.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    @Override
    public List<Category> findAllById(Iterable<Long> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    @Override
    public <S extends Category> List<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        categoryRepository.flush();
    }

    @Override
    public <S extends Category> S saveAndFlush(S s) {
        return categoryRepository.saveAndFlush(s);
    }

    @Override
    public <S extends Category> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return categoryRepository.saveAllAndFlush(iterable);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Category> entities) {
        categoryRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Category> iterable) {
        categoryRepository.deleteAllInBatch(iterable);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {
        categoryRepository.deleteAllByIdInBatch(iterable);
    }

    @Override
    @Deprecated
    public Category getOne(Long aLong) {
        return categoryRepository.getOne(aLong);
    }

    @Override
    public Category getById(Long aLong) {
        return categoryRepository.getById(aLong);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public <S extends Category> S save(S s) {
        return categoryRepository.save(s);
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return categoryRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {
        categoryRepository.deleteAllById(iterable);
    }

    @Override
    public void deleteAll(Iterable<? extends Category> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public <S extends Category> Optional<S> findOne(Example<S> example) {
        return categoryRepository.findOne(example);
    }

    @Override
    public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Category> long count(Example<S> example) {
        return categoryRepository.count(example);
    }

    @Override
    public <S extends Category> boolean exists(Example<S> example) {
        return categoryRepository.exists(example);
    }

    @Override
    public List<Category> findByNameContaining(String name) {
        return categoryRepository.findByNameContaining(name);
    }

    @Override
    public Page<Category> findByNameContaining(String name, Pageable page) {
        return categoryRepository.findByNameContaining(name, page);
    }
}
