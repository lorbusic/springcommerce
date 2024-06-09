package com.lorbusic.springcommerce.service.impl;

import com.google.gson.Gson;
import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.dto.VariationDto;
import com.lorbusic.springcommerce.mapper.ProductMapper;
import com.lorbusic.springcommerce.mapper.VariationMapper;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.User;
import com.lorbusic.springcommerce.model.Variation;
import com.lorbusic.springcommerce.repository.ProductRepository;
import com.lorbusic.springcommerce.repository.VariationRepository;
import com.lorbusic.springcommerce.service.VariationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariationServiceImpl implements VariationService {

    private final VariationRepository variationRepository;
    private final VariationMapper variationMapper;

    @Autowired
    public VariationServiceImpl(VariationRepository variationRepository, VariationMapper variationMapper) {
        this.variationRepository = variationRepository;
        this.variationMapper = variationMapper;
    }

    @Override
    public VariationDto createVariation(VariationDto variationDto){
        Gson json = new Gson();
        ProductDto productDto=variationDto.getProductDto();
        variationDto.setProductDto(productDto);
        Variation variation = variationMapper.toEntity(variationDto);
        System.out.println(json.toJson(variation));
        Variation saveVariation = variationRepository.save(variation);
        return variationMapper.toDto(saveVariation);
    }

    @Override
    public List<Variation> getAllVariationsOf(){
        return new ArrayList<Variation>(variationRepository.getAllVariations());
    }

}
