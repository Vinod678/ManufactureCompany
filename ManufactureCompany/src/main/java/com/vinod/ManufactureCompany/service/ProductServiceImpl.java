package com.vinod.ManufactureCompany.service;

import com.vinod.ManufactureCompany.model.Product;
import com.vinod.ManufactureCompany.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void createProduct(Product product) {
        logger.info("Creating product: {}", product);
        productRepository.save(product);
    }
    @Override
    public void createProducts(List<Product> products) {
        for (Product product : products) {
            // Perform any validation or processing as needed
            createProduct(product);
        }
    }


    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void editProduct(Product product) {

    }

    @Override
    public void editProduct(int id, Product product) {
        if (productRepository.existsById(id)) {
            product.setProdId(id);
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
