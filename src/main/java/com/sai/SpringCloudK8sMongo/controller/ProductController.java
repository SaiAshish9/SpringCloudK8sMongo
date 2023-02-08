package com.sai.SpringCloudK8sMongo.controller;

import com.sai.SpringCloudK8sMongo.entity.Product;
import com.sai.SpringCloudK8sMongo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public String saveProduct(@RequestBody Product product) {
        productRepository.save(product);
        return "Product added successfully : "+product.getId();
    }

    @GetMapping("/findAllProducts")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/findProduct/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Deleted Product Successfully : "+id;
    }

}

