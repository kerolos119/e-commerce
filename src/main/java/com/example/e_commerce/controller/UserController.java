package com.example.e_commerce.controller;

import com.example.e_commerce.dto.UserDto;
import com.example.e_commerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public String save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable String id){
        return userService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        userService.deleteById(id);
    }
    @PutMapping("{/id}")
    public UserDto updateById(@PathVariable String id ,@RequestBody UserDto dto){
        return userService.updateById(id,dto);
    }
}
