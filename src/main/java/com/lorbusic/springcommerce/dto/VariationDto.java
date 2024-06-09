package com.lorbusic.springcommerce.dto;

import com.lorbusic.springcommerce.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
public class VariationDto {

    private Long variationId;
    private ProductDto productDto;
    private String variationName;
    private String variationTag;
    private String variationValue;

}
