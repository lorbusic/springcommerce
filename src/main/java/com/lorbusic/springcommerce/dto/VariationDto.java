package com.lorbusic.springcommerce.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VariationDto {

    private Long id;
    private String variationName;
    private String variationTag;
    private String variationValue;

}
