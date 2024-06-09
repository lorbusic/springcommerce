package com.lorbusic.springcommerce.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
public class UserDto {

    private Long id;

    private String userFirstName;

    private String userLastName;

    private String userMail;

    private String userPsd;

    private String userFiscalCode;

    private String userAddress;



}















