package com.example.e_commerce.services;
import com.example.e_commerce.document.Manifacture;
import com.example.e_commerce.excpetion.CustomException;
import com.example.e_commerce.repo.ManifactureRepository;
import com.example.e_commerce.dto.ManifactureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ManifactureService {
    @Autowired
    private ManifactureRepository manRepo;
    public String save(ManifactureDto mancont) {
        return manRepo.save(new Manifacture(mancont)).getId();
    }
    public List<ManifactureDto> getAll(){
        List<Manifacture> manifacture=manRepo.findAll();
        List<ManifactureDto> mandto=new ArrayList<>();
        for(Manifacture entity: manifacture){
            mandto.add(new ManifactureDto(entity));
        }
        return mandto;
    }
    public ManifactureDto getById(String id) {
        Optional<Manifacture> entity=manRepo.findById(id);
        if (entity.isPresent()){
            return new ManifactureDto(entity.get());
        }
        throw new CustomException("manifacture.not.found", HttpStatus.NOT_FOUND);
    }
    public void deleteById(String id) {
        if (!manRepo.existsById(id)){
            throw new CustomException("manifacture.not.found",HttpStatus.NOT_FOUND);

        }
        manRepo.deleteById(id);
    }

    public ManifactureDto updateById(String id, ManifactureDto mdto) {
        Manifacture oldman;
        oldman = new Manifacture(getById(id));
        oldman.setName(mdto.getName());
        oldman.setDescription(mdto.getDescription());
        oldman.setNationality(mdto.getNationality());
        return new ManifactureDto(manRepo.save(oldman));
    }

    public boolean manifactureExist(String manifacture) {
        return manRepo.existsById(manifacture);
    }
}
