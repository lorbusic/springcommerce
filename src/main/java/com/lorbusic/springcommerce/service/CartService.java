package com.lorbusic.springcommerce.service;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.model.Cart;

public interface CartService {

    public CartDto createCart(CartDto cartDto);
}
