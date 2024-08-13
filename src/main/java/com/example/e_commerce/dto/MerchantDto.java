package com.example.e_commerce.dto;

import com.example.e_commerce.document.Merchant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto {
    public MerchantDto(Merchant merdoc){
        this.id=merdoc.getId();
        this.name=merdoc.getName();
        this.description=merdoc.getDescription();
        this.address=merdoc.getAddress();
        this.phone=merdoc.getPhone();
    }

    private String id;
    private String name;
    private String description;
    private String address;
    private String phone;

}
