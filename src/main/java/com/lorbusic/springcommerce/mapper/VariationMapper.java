package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.dto.VariationDto;
import com.lorbusic.springcommerce.model.User;
import com.lorbusic.springcommerce.model.Variation;
import org.aspectj.weaver.ast.Var;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface VariationMapper {

    @Mapping(source = "variationId", target="variationId")
    @Mapping(source = "variationName", target = "variationName")
    @Mapping(source = "variationTag", target = "variationTag")
    @Mapping(source = "variationValue", target = "variationValue")
    @Mapping(source = "product", target = "productDto")
    public VariationDto toDto(Variation variation);

    @Mapping(source = "variationId",target="variationId")
    @Mapping(source = "variationName", target = "variationName")
    @Mapping(source = "variationTag", target = "variationTag")
    @Mapping(source = "variationValue", target = "variationValue")
    @Mapping(source = "productDto", target = "product")
    public Variation toEntity(VariationDto dto);

    public List<VariationDto> variationToVariationDtos(List<Variation> variations);
}





