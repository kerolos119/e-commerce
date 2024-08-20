package com.example.e_commerce.dto;

import com.example.e_commerce.document.User;
import com.example.e_commerce.type.Type;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public UserDto (User entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.address=entity.getAddress();
        this.phone=entity.getPhone();
        this.email=entity.getEmail();
        this.type=entity.getType();

    }
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phone;
    @NotEmpty
    private Type type;
    private String email;
}
