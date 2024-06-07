package com.lorbusic.springcommerce.service.impl;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.mapper.CartMapper;
import com.lorbusic.springcommerce.model.Cart;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.repository.CartRepository;
import com.lorbusic.springcommerce.service.CartService;
import com.lorbusic.springcommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {


    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository, CartRepository cartRepository,  CartMapper cartMapper) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    //Inserisco il prodotto nel carrello portandomi il prezzo e l'id del prodotto
    @Override
    public CartDto createCart(CartDto cartDto){
        Long productId = cartDto.getProductId();
        Product product = productRepository.findById(Math.toIntExact(productId)).orElse(null);
        if (product != null) {
            Double productPrice = product.getProductPrice();
            cartDto.setProductPrice(productPrice);
            cartDto.setProductId(productId);
        }
        Cart cart = CartMapper.toEntity(cartDto);
        Cart saveCart = cartRepository.save(cart);
        return CartMapper.toDto(saveCart);
    }
}
