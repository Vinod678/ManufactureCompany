package com.vinod.ManufactureCompany.controller;
import com.vinod.ManufactureCompany.model.Product;
import com.vinod.ManufactureCompany.repository.ProductRepository;
import com.vinod.ManufactureCompany.service.ProductService;
import com.vinod.ManufactureCompany.service.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600)
public class Controller {
    @Autowired
    private ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);


    // ... existing mappings ...

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

//    @GetMapping
//    public ResponseEntity<Page<Product>> getProducts(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(defaultValue = "prodId") String sortBy) {
//
//        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
//
//        Page<Product> products = productService.getAllProductsPaginated(pageable);
//
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.ok("Product created successfully");
    }
    @PostMapping("/createProducts")
    public ResponseEntity<?> createProducts(@RequestBody List<Product> products) {
        // Handle the list of products
        logger.info("Received request to create products: {}", products);
        productService.createProducts(products);
        return ResponseEntity.ok("Products created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editProduct(@PathVariable String id, @RequestBody Product product) {
        productService.editProduct(id, product);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteProducts() {
        productService.deleteProducts();
        return ResponseEntity.ok("All Products deleted successfully");
    }

    @GetMapping("/sortedByName")
    public List<Product> getAllProductsSortedByName() {
        return productService.getAllProductsSortedByName();
    }
    @GetMapping("/sortedById")
    public List<Product> getAllProductsSortedById(){
        return productService.getAllProductsSortedById();
    }



}