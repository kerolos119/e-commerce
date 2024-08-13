package com.example.e_commerce.document;

import com.example.e_commerce.dto.MerchantDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Merchant {
    public Merchant(MerchantDto merdto){
        this.id=merdto.getId();
        this.name=merdto.getName();
        this.description=merdto.getDescription();
        this.address=merdto.getAddress();
        this.phone=merdto.getPhone();
    }
    @Id
    private String id;
    private String name;
    private String description;
    private String address;
    private String phone;
}
