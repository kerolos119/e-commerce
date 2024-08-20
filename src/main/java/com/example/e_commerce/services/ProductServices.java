package com.example.e_commerce.services;

import com.example.e_commerce.document.Manifacture;
import com.example.e_commerce.document.Merchant;
import com.example.e_commerce.document.Product;
import com.example.e_commerce.dto.ManifactureDto;
import com.example.e_commerce.dto.MerchantDto;
import com.example.e_commerce.dto.ProductDto;
import com.example.e_commerce.excpetion.CustomException;
import com.example.e_commerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductServices {
    @Autowired
    private ProductRepository prepo;
    @Autowired
    private ManifactureService manservice;
    @Autowired
    private MerchantService merservice;

    public String save(ProductDto pdto) {
        if (pdto.getManifacture() != null && !manservice.manifactureExist(pdto.getManifacture()))
            throw new CustomException("manifacture.not.found", HttpStatus.BAD_REQUEST);
        if (pdto.getMerchent() != null && !merservice.merchantExist(pdto.getMerchent()))
            throw new CustomException("",HttpStatus.BAD_REQUEST);
        return prepo.save(new Product(pdto)).getId();
    }

    public List<ProductDto> getAll() {
        List<Product> products = prepo.findAll();
        List<ManifactureDto> manifactures = manservice.getAll();
        List<MerchantDto> merchants = merservice.getAll();
        List<ProductDto> prdto = new ArrayList<>();
        for (Product entity : products) {
            ProductDto productDto = new ProductDto(entity);
            if (productDto.getManifacture() != null) {
                for (ManifactureDto dto : manifactures) {
                    if (dto.getId().equals(productDto.getManifacture()))
                        productDto.setManifactureName(dto.getName());
                }

            }

            if (productDto.getMerchent() != null) {
                for (MerchantDto dto : merchants) {
                    if (dto.getId().equals(productDto.getMerchent()))
                        productDto.setMerchantName(dto.getName());
                }
            }
            prdto.add(productDto);
        }
        return prdto;
    }

    public ProductDto getById(String id) {
        Optional<Product> entity = prepo.findById(id);
        if (entity.isPresent()) {

            ProductDto dto=new ProductDto(entity.get());
            if (dto.getManifacture()!=null && !dto.getManifacture().isEmpty()) {
                ManifactureDto manifactureDto = manservice.getById(dto.getManifacture());
                dto.setManifactureName(manifactureDto.getName());
            }
            if (dto.getMerchent()!= null && !dto.getMerchent().isEmpty()){
                MerchantDto merchantDto =merservice.getById(dto.getMerchent());
                dto.setMerchantName(merchantDto.getName());
            }
            return dto;
        }
        throw new CustomException("product.not.found",HttpStatus.NOT_FOUND);
    }

    public void deleteByIs(String id) {
        if (!prepo.existsById(id)){
            throw new CustomException("product.not.found",HttpStatus.NOT_FOUND);

        }
        prepo.deleteById(id);
    }

    public ProductDto updateById(String id, ProductDto dto) {
        if (dto.getManifacture() != null && !manservice.manifactureExist(dto.getManifacture()))
            throw new CustomException("manifacture.not.found", HttpStatus.BAD_REQUEST);
        if (dto.getMerchent() != null && !merservice.merchantExist(dto.getMerchent()))
            throw new CustomException("merchant.not.found",HttpStatus.BAD_REQUEST);
        Product oldproduct = new Product(getById(id));
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
