package com.lorbusic.springcommerce.service;

import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.dto.VariationDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.Variation;

import java.util.List;

public interface VariationService {


    public VariationDto createVariation(VariationDto variationDto);


    public List<Variation> getAllVariationsOf();
}
