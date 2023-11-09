package com.huydevtr.demo.services;

import com.huydevtr.demo.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public Product findByID(int id_product);

    public void save(Product product);

    public void deleteByID(int id_product);
    public Page<Product> findAllOrderBySNumber(int page, int limit);

}
