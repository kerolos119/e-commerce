package com.example.e_commerce.document;

import com.example.e_commerce.dto.ProductDto;
import com.example.e_commerce.model.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Product {
    public Product(ProductDto dto){

        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
        this.color = dto.getColor();
        this.size = dto.getSize();
        this.manifacture = dto.getManifacture();
        this.merchent = dto.getMerchent();
        this.stock = dto.getStock();
        this.isOffered = dto.getIsOffered();
        this.offer = dto.getOffer();

    }
    @Id
    private String id;
    private String name;
    private String description;
    private Float price;
    private String color;
    private Size size;
    private String manifacture;
    private String merchent;
    private Integer stock;
    private Boolean isOffered;
    private Float offer;


}
