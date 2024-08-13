package com.example.e_commerce.document;

import com.example.e_commerce.dto.ManifactureDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Document
public class Manifacture {
    public Manifacture(ManifactureDto mandto){
        this.id=mandto.getId();
        this.name=mandto.getName();
        this.description=mandto.getDescription();
        this.nationality=mandto.getNationality();
    }
    @Id
    private String id;
    private String name;
    private String description;
    private String nationality;

}
