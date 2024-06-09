package com.lorbusic.springcommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDto {

    private Long id;


    //Questi attributi indicheranno quale Product è stato
    //inserito nel carrello di uno specifico User
    private ProductDto productDto;
    private UserDto userDto;

    private Long productId;
    private Double productPrice;


}
