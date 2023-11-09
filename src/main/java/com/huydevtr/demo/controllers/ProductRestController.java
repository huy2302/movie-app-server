package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.Product;
import com.huydevtr.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "rest-product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping("/category")
    public ResponseEntity<List<Product>> listResponseEntity (
            @RequestParam String category
    ) {
        List<Product> productCategories = productService.findAll();

        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }
}
