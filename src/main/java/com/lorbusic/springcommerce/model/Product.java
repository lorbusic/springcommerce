package com.lorbusic.springcommerce.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_description")
    private String productDescription;

    @Column(name="product_price")
    private Double productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Variation> variations;

}
