package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.model.Cart;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartMapper {

    public static CartDto toDto(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .productId(cart.getProductId())
                .productPrice(cart.getProductPrice())
                .build();
    }

    public static Cart toEntity(CartDto dto) {
        return Cart.builder()
                .id(dto.getId())
                .productId(dto.getProductId())
                .productPrice(dto.getProductPrice())
                .build();
    }
}
