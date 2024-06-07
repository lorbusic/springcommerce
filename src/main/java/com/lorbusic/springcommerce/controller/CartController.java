package com.lorbusic.springcommerce.controller;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.service.impl.CartServiceImpl;
import com.lorbusic.springcommerce.repository.CartRepository;
import com.lorbusic.springcommerce.repository.ProductRepository;

import com.lorbusic.springcommerce.service.impl.ProductServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class CartController {
    private  final CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService){
        this.cartService=cartService;
    }


    @PostMapping(value = "/admin/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto) {
        CartDto newCart = cartService.createCart(cartDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newCart);
    }
}
