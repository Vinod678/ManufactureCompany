package com.vinod.ManufactureCompany.service;

import com.vinod.ManufactureCompany.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void createProduct(Product product);
    void deleteProduct(Product product);
    void editProduct(Product product);

    void editProduct(int id, Product product);

    void deleteProduct(int id);

    void createProducts(List<Product> products);
}
