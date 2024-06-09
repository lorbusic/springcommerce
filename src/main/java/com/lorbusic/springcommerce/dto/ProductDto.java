package com.lorbusic.springcommerce.dto;

import com.lorbusic.springcommerce.model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Builder
public class ProductDto {

    private Long id;

    private String productName;
    private String productDescription;
    private Double productPrice;

    private List<VariationDto> variationList;

}
