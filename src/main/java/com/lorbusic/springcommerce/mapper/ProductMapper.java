package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.model.Product;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductMapper {

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .build();
    }

    public static Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .productName(dto.getProductName())
                .productDescription(dto.getProductDescription())
                .productPrice(dto.getProductPrice())
                .build();
    }
}
