package com.example.shoppingmall.service.impl;

import com.example.shoppingmall.domain.ImageProduct;
import com.example.shoppingmall.respository.ImageProductRepository;
import com.example.shoppingmall.service.ImageProductService;
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
public class ImageProductServiceImpl implements ImageProductService {
    private final ImageProductRepository imageProductRepository;

    @Override
    public List<ImageProduct> findAll() {
        return imageProductRepository.findAll();
    }

    @Override
    public List<ImageProduct> findAll(Sort sort) {
        return imageProductRepository.findAll(sort);
    }

    @Override
    public List<ImageProduct> findAllById(Iterable<Long> iterable) {
        return imageProductRepository.findAllById(iterable);
    }

    @Override
    public <S extends ImageProduct> List<S> saveAll(Iterable<S> iterable) {
        return imageProductRepository.saveAll(iterable);
    }

    @Override
    public void flush() {
        imageProductRepository.flush();
    }

    @Override
    public <S extends ImageProduct> S saveAndFlush(S s) {
        return imageProductRepository.saveAndFlush(s);
    }

    @Override
    public <S extends ImageProduct> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return imageProductRepository.saveAllAndFlush(iterable);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<ImageProduct> entities) {
        imageProductRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<ImageProduct> iterable) {
        imageProductRepository.deleteAllInBatch(iterable);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> iterable) {
        imageProductRepository.deleteAllByIdInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        imageProductRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public ImageProduct getOne(Long aLong) {
        return imageProductRepository.getOne(aLong);
    }

    @Override
    public ImageProduct getById(Long aLong) {
        return imageProductRepository.getById(aLong);
    }

    @Override
    public <S extends ImageProduct> List<S> findAll(Example<S> example) {
        return imageProductRepository.findAll(example);
    }

    @Override
    public <S extends ImageProduct> List<S> findAll(Example<S> example, Sort sort) {
        return imageProductRepository.findAll(example, sort);
    }

    @Override
    public Page<ImageProduct> findAll(Pageable pageable) {
        return imageProductRepository.findAll(pageable);
    }

    @Override
    public <S extends ImageProduct> S save(S s) {
        return imageProductRepository.save(s);
    }

    @Override
    public Optional<ImageProduct> findById(Long aLong) {
        return imageProductRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return imageProductRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return imageProductRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        imageProductRepository.deleteById(aLong);
    }

    @Override
    public void delete(ImageProduct imageProduct) {
        imageProductRepository.delete(imageProduct);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> iterable) {
        imageProductRepository.deleteAllById(iterable);
    }

    @Override
    public void deleteAll(Iterable<? extends ImageProduct> iterable) {
        imageProductRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        imageProductRepository.deleteAll();
    }

    @Override
    public <S extends ImageProduct> Optional<S> findOne(Example<S> example) {
        return imageProductRepository.findOne(example);
    }

    @Override
    public <S extends ImageProduct> Page<S> findAll(Example<S> example, Pageable pageable) {
        return imageProductRepository.findAll(example, pageable);
    }

    @Override
    public <S extends ImageProduct> long count(Example<S> example) {
        return imageProductRepository.count(example);
    }

    @Override
    public <S extends ImageProduct> boolean exists(Example<S> example) {
        return imageProductRepository.exists(example);
    }
}
