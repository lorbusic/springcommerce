package com.lorbusic.springcommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDto {

    private Long id;

    private Long productId;

    private Double productPrice;


}
