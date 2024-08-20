package com.example.e_commerce.services;

import com.example.e_commerce.document.Product;
import com.example.e_commerce.document.User;
import com.example.e_commerce.dto.ProductDto;
import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.excpetion.CustomException;
import com.example.e_commerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userepo;

    public String save(UserDto userDto) {
        return userepo.save(new User(userDto)).getId();
    }

    public List<UserDto> getAll() {
        List<User> users = userepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User entity : users) {
            UserDto userDto = new UserDto(entity);
        }
        return userDtos;
    }

    public UserDto getById(String id) {
        Optional<User> entity=userepo.findById(id);
        if (entity.isPresent()){
            UserDto dto =new UserDto(entity.get());
            return dto;
        }
        throw new CustomException("user.not.found", HttpStatus.NOT_FOUND);
    }

    public void deleteById(String id) {
        if (!userepo.existsById(id)){
            throw new CustomException("user.not.found", HttpStatus.NOT_FOUND);
        }
        userepo.deleteById(id);
    }

    public UserDto updateById(String id, UserDto dto) {
        User olduser=new User(getById(id));
        olduser.setName((dto.getName()));
        olduser.setType((dto.getType()));
        olduser.setAddress((dto.getAddress()));
        olduser.setPhone((dto.getPhone()));
        olduser.setEmail((dto.getEmail()));
        return new UserDto(userepo.save(olduser));
    }
}
