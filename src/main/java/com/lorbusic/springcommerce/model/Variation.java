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
@Table(name = "variation")
public class Variation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "variation_name",length = 100) //Esempio "Taglia" oppure "Colore"
    private String variationName;

    @Column(name = "variation_tag",length = 100) //Esempio "taglia" oppure "colore"
    private String variationTag;

    @Column(name = "variation_value",length = 100) //Esempioi "S","M","L",... oppure "blue","red","orange","white" ...
    private String variationValue;

}



