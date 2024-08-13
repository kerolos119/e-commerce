package com.example.e_commerce.controller;

import com.example.e_commerce.dto.ManifactureDto;
import com.example.e_commerce.services.ManifactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manifacture")
public class ManifactureController {
    @Autowired
    private ManifactureService maniservice;

    @PostMapping
    public String save(@RequestBody ManifactureDto mancont) {

        return maniservice.save(mancont);
    }
    @GetMapping
    public List<ManifactureDto> getAll(){
        return maniservice.getAll();
    }
    @GetMapping({"/id"})
    public ManifactureDto getById(@PathVariable String id){
        return maniservice.getById(id);
    }
    @DeleteMapping({"/id"})
    public void  deleteByid(@PathVariable String id){
        maniservice.deleteById(id);
    }
    @PutMapping({"/id"})
    public ManifactureDto updateById(@PathVariable String id ,@RequestBody ManifactureDto mdto){
        return maniservice.updateById(id,mdto);
    }

}
