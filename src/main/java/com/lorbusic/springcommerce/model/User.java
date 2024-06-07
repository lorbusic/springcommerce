package com.lorbusic.springcommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_first_name",length = 255)
    private String userFirstName;

    @Column(name = "user_last_name",length = 255)
    private String userLastName;

    @Column(name = "user_mail",length = 255) //EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private String userMail;

    @Column(name = "user_psd",length = 50) //Psd massimo 50 caratteri
    private String userPsd;

    @Column(name = "user_fiscal_code", length=16) //Imposto a 16 caratteri il valore max del codice fiscale
    private String userFiscalCode;

    @Column(name="user_address",length = 500)
    private String userAddress;



}















