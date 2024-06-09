package com.lorbusic.springcommerce.controller;

import com.google.gson.Gson;
import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.dto.VariationDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.Variation;
import com.lorbusic.springcommerce.repository.ProductRepository;
import com.lorbusic.springcommerce.repository.VariationRepository;
import com.lorbusic.springcommerce.service.VariationService;
import com.lorbusic.springcommerce.service.impl.ProductServiceImpl;
import com.lorbusic.springcommerce.service.impl.VariationServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variations")
public class VariationController {

    private  final VariationServiceImpl variationService;
    @Autowired
    public VariationController(VariationServiceImpl variationService) {
        this.variationService = variationService;
    }

    @PostMapping(value = "/variation/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<VariationDto> createProduct(@RequestBody VariationDto variationDto, Authentication authentication) {

        VariationDto newVar = variationService.createVariation(variationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVar);
    }



    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Variation>> getAllVariationsOf() {
        List<Variation> variations = variationService.getAllVariationsOf();
        return  ResponseEntity.ok(variations);
    }
}
