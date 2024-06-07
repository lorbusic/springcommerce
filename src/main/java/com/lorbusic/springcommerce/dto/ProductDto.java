package com.lorbusic.springcommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Builder
public class ProductDto {

    private Long id;

    private String productName;
    private String productDescription;
    private Double productPrice;


}
