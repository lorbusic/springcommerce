package com.lorbusic.springcommerce.service;

import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.model.Product;

import java.util.List;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);
    public List<Product> getAllProducts();
    public List<Product> getAllProductsByNameSorted();
    public Product getProductById(Long id);

    public boolean updateProductById(Long id, ProductDto productDto);
    public boolean deleteProductById(Long id);
}
