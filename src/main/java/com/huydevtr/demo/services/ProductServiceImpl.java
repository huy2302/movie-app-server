package com.huydevtr.demo.services;

import com.huydevtr.demo.models.Product;
import com.huydevtr.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Product findByID(int id_product) {
        Optional<Product> result = productRepository.findById(id_product);

        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("Did not find product id - " + id_product);
        }

        return product;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void deleteByID(int id_product) {

    }

    @Override
    public Page<Product> findAllOrderBySNumber(int page, int limit) {
        Pageable topTwenty = PageRequest.of(page, limit);
        Page<Product> notifications = productRepository.findAll((Pageable) topTwenty);
        return notifications;
    }

}
