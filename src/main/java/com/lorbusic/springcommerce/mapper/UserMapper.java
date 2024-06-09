package com.lorbusic.springcommerce.mapper;

import com.lorbusic.springcommerce.dto.CartDto;
import com.lorbusic.springcommerce.dto.ProductDto;
import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.model.Cart;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {

    UserDto toDto(User product);

    User toEntity(UserDto productDto);

    List<UserDto> userToUserDtos(List<User> cartList);

}