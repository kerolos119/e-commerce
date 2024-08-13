package com.example.e_commerce.controller;

import com.example.e_commerce.dto.MerchantDto;
import com.example.e_commerce.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merservice;
    @PostMapping
    public String save(@RequestBody MerchantDto merdto){
        return merservice.save(merdto);
    }
    @GetMapping
    public List<MerchantDto> getAll(){
        return merservice.getAll();
    }
    @GetMapping({"/id"})
    public MerchantDto getById (@PathVariable String id){
        return merservice.getById(id);
    }
    @DeleteMapping({"/id"})
    public void deleteById(@PathVariable String id){
        merservice.deleteById(id);
    }
    @PutMapping({"/id"})
    public MerchantDto updateById(@PathVariable String id ,@RequestBody MerchantDto merdto){
        return merservice.updateById(id,merdto);
    }
}
