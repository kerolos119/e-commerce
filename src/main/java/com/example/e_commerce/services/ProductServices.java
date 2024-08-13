package com.example.e_commerce.services;

import com.example.e_commerce.document.Product;
import com.example.e_commerce.dto.ProductDto;
import com.example.e_commerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductServices {
    @Autowired
    private ProductRepository prepo;

    public String save(ProductDto pdto) {
        return prepo.save(new Product(pdto)).getId();
    }
    public List<ProductDto> getAll(){
        List<Product> products=prepo.findAll();
        List<ProductDto> prdto=new ArrayList<>();
        for(Product entity: products){
            prdto.add(new ProductDto(entity));
        }
        return prdto;
    }
    public ProductDto getById(String id) {
        Optional<Product> entity=prepo.findById(id);
        if (entity.isPresent()){
            return new ProductDto(entity.get());
        }
        throw new RuntimeException("Not Found Id (please try again)");
    }

    public void deleteByIs(String id) {
        prepo.deleteById(id);
    }

    public ProductDto updateById(String id, ProductDto dto) {
       Product oldproduct= new Product(getById(id));
       oldproduct.setName(dto.getName());
       oldproduct.setManifacture(dto.getMerchent());
       oldproduct.setManifacture(dto.getManifacture());
       oldproduct.setColor(dto.getColor());
       oldproduct.setStock(dto.getStock());
       oldproduct.setIsOffered(dto.getIsOffered());
       oldproduct.setPrice(dto.getPrice());
       oldproduct.setDescription(dto.getDescription());
       return new ProductDto(prepo.save(oldproduct));

    }

}
