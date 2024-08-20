package com.example.e_commerce.document;

import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.type.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    public User (UserDto dto){
    this.id=dto.getId();
    this.name=dto.getName();
    this.address=dto.getAddress();
    this.phone=dto.getPhone();
    this.email=dto.getEmail();
    this.type=dto.getType();

}
    private String id;
    private String name;
    private String address;
    private String phone;
    private Type type;
    private String email;

}
