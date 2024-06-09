package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.model.Cart;
import com.lorbusic.springcommerce.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface CartMapper {

    CartDto toDto(Cart product);

    Cart toEntity(CartDto productDto);

    List<CartDto> cartToCartDtos(List<Cart> cartList);

}