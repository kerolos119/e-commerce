package com.example.e_commerce.dto;

import com.example.e_commerce.document.Merchant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phone;

}
