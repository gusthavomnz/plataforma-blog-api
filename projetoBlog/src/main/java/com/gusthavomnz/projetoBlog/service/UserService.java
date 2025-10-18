package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.UserDTO;
import com.gusthavomnz.projetoBlog.model.User;
import com.gusthavomnz.projetoBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    @Transactional
    public UserDTO criarUser(UserDTO userDTO){
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());

        User usuarioSalvo = userRepository.save(user);

        return new UserDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                null,null,null);
    }


}
