package com.example.e_commerce.services;
import com.example.e_commerce.document.Manifacture;
import com.example.e_commerce.repo.ManifactureRepository;
import com.example.e_commerce.dto.ManifactureDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ManifactureService {
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
        throw new RuntimeException("Not Found Id (please try again)");
    }
    public void deleteById(String id) {
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
}
