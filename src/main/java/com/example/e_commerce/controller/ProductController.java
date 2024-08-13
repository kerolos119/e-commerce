package com.example.e_commerce.controller;

import com.example.e_commerce.dto.ProductDto;
import com.example.e_commerce.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
//@Controller("/p")
public class ProductController {
    @Autowired
    private ProductServices prservices;

    @PostMapping
    public String save(@RequestBody ProductDto pdto) {

        return prservices.save(pdto);
    }
    @GetMapping
    public List<ProductDto> getAll(){
        return prservices.getAll();
    }
    @GetMapping("/{id}")
    public  ProductDto getById(@PathVariable String id){
        return prservices.getById(id);
    }
    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable String id){
         prservices.deleteByIs(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateById(@PathVariable String id ,@RequestBody ProductDto dto){

        return prservices.updateById(id,dto);
    }
}
