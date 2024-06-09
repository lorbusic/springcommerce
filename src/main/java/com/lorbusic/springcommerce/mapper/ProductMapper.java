package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

//MAPSTRUCT
@Mapper(componentModel="spring")
public interface ProductMapper {
    @Mapping(source = "id",target="id")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productDescription", target = "productDescription")
    @Mapping(source = "productPrice", target = "productPrice")
    ProductDto toDto(Product product);

    @Mapping(source = "id",target="id")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "productDescription", target = "productDescription")
    @Mapping(source = "productPrice", target = "productPrice")
    Product toEntity(ProductDto productDto);

    List<ProductDto> productToProductDtos(List<Product> productList);

}
