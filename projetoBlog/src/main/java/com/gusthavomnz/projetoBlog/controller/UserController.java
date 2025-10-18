package com.gusthavomnz.projetoBlog.controller;


import com.gusthavomnz.projetoBlog.dto.UserDTO;
import com.gusthavomnz.projetoBlog.model.User;
import com.gusthavomnz.projetoBlog.repository.UserRepository;
import com.gusthavomnz.projetoBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gusthavomnz/blog")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Transactional
    @PostMapping(value = "/user")
    public ResponseEntity<String> criarUsuario(@RequestBody UserDTO userDTO){
        userService.criarUser(userDTO);
        return ResponseEntity.ok("Usuario criado!");
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/user")
    public List<User> listaUsuarios(){
        return userRepository.findAll();
    }








}
