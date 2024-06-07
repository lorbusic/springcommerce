package com.lorbusic.springcommerce.mapper;


import com.lorbusic.springcommerce.dto.UserDto;
import com.lorbusic.springcommerce.model.Product;
import com.lorbusic.springcommerce.model.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserMapper {

    public static UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .userFirstName(user.getUserFirstName())
                .userLastName(user.getUserLastName())
                .userMail(user.getUserMail())
                .userPsd(user.getUserPsd())
                .userFiscalCode(user.getUserFiscalCode())
                .userAddress(user.getUserAddress()).build();
    }

    public static User toEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .userFirstName(dto.getUserFirstName())
                .userLastName(dto.getUserLastName())
                .userMail(dto.getUserMail())
                .userPsd(dto.getUserPsd())
                .userFiscalCode(dto.getUserFiscalCode())
                .userAddress(dto.getUserAddress()).build();
    }

}
