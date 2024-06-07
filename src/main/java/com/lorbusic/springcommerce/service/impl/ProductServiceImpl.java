package com.lorbusic.springcommerce.service.impl;

import com.lorbusic.springcommerce.mapper.ProductMapper;
import com.lorbusic.springcommerce.repository.ProductRepository;
import com.lorbusic.springcommerce.service.ProductService;
import com.lorbusic.springcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorbusic.springcommerce.dto.ProductDto;

import java.util.*;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto){
        Product product = ProductMapper.toEntity(productDto);
        Product saveProduct = productRepository.save(product);
        return ProductMapper.toDto(saveProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.findAllSortedById());
    }

    @Override
    public List<Product> getAllProductsByNameSorted() {
        return new ArrayList<>(productRepository.findAllSortedByProductName());
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public boolean updateProductById(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(Math.toIntExact(id)).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductDescription(productDto.getProductDescription());
            productRepository.save(existingProduct);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteProductById(Long id) {
        if (productRepository.existsById(Math.toIntExact(id))) {
            productRepository.deleteById(Math.toIntExact(id));
            return true;
        } else {
            return false;
        }
    }
}
