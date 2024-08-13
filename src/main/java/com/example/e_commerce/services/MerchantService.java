package com.example.e_commerce.services;

import com.example.e_commerce.document.Merchant;
import com.example.e_commerce.dto.MerchantDto;
import com.example.e_commerce.repo.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merepo;
    public String save(MerchantDto merdto) {
        return merepo.save(new Merchant(merdto)).getId();
    }
    public List<MerchantDto> getAll(){
        List<Merchant> merdoc=merepo.findAll();
        List<MerchantDto>merdto=new ArrayList<>();
        for (Merchant entity:merdoc){
            merdto.add(new MerchantDto(entity));
        }
        return merdto;
    }
    public MerchantDto getById(String id){
        Optional<Merchant> entity = merepo.findById(id);
        if (entity.isPresent()){
            return new MerchantDto(entity.get());
        }
        throw new RuntimeException("Not Found Id (please try again)");
    }
    public void deleteById(String id){
        merepo.deleteById(id);
    }

    public MerchantDto updateById(String id, MerchantDto merdto) {
        Merchant oldmer = new Merchant(getById(id));
        oldmer.setName((merdto.getName()));
        oldmer.setDescription((merdto.getDescription()));
        oldmer.setAddress((merdto.getAddress()));
        oldmer.setPhone((merdto.getPhone()));
        return new MerchantDto(merepo.save(oldmer));
    }
}
