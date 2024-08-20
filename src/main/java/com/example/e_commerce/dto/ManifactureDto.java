package com.example.e_commerce.dto;

import com.example.e_commerce.document.Manifacture;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManifactureDto {
    public ManifactureDto(Manifacture mandoc){
        this.id=mandoc.getId();
        this.name= mandoc.getName();
        this.description=mandoc.getDescription();
        this.nationality=mandoc.getNationality();
    }
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String nationality;
}
