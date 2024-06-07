package com.lorbusic.springcommerce.controller;


import com.lorbusic.springcommerce.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.service.impl.ProductServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private  final  ProductServiceImpl productService;
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductServiceImpl productService, ProductRepository productRepository){
        this.productService=productService;
        this.productRepository = productRepository;
    }


    @PostMapping(value = "/admin/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, Authentication authentication) {
       ProductDto newProduct = productService.createProduct(productDto);
       return  ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return  ResponseEntity.ok(products);
    }

    @GetMapping(value = "/vedi", produces = "application/json")
    public ModelAndView vedi() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping(value = "/allByName", produces = "application/json")
    public ResponseEntity<List<Product>> getAllProductsByNameSorted() {
        List<Product> products = productService.getAllProductsByNameSorted();
        return  ResponseEntity.ok(products);
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        boolean booleanResponseEntity = productService.updateProductById(id,productDto);
        if(booleanResponseEntity) return ResponseEntity.ok("Succesfull");
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProductById(@PathVariable Long id) {
        boolean isDeleted = productService.deleteProductById(id);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Autowired
    private EntityManager entityManager;
    @GetMapping(value = "/checkDatabaseConnection")
    public ResponseEntity<String> checkDatabaseConnection() {
        try {
            entityManager.createNativeQuery("SELECT 1").getResultList();
            return ResponseEntity.ok("Connessione al database riuscita.");
        } catch (PersistenceException e) {
            return ResponseEntity.status(500).body("Errore durante la connessione al database: " + e.getMessage());
        }
    }
}
