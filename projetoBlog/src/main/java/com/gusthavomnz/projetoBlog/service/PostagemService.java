package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.PostagemDTO;
import com.gusthavomnz.projetoBlog.dto.UserDTO;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.model.User;
import com.gusthavomnz.projetoBlog.repository.PostagemRepository;
import com.gusthavomnz.projetoBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostagemService {

    @Autowired
    PostagemRepository postagemRepository;

    @Autowired
    UserRepository userRepository;

@Transactional
    public PostagemDTO criarPostagem(PostagemDTO postagemDTO) {

        User autor = userRepository.findById(postagemDTO.getUserDTO().getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Postagem novaPostagem = new Postagem();

        novaPostagem.setTitulo(postagemDTO.getTitulo());
        novaPostagem.setConteudo(postagemDTO.getConteudo());
        novaPostagem.setUsuario(autor);

        Postagem postagemSalva = postagemRepository.save(novaPostagem);

        // MAPEAMENTO PARA DTO PARA FAZER O RETURN

        User u = postagemSalva.getUsuario();
        UserDTO userDTO = new UserDTO(u.getId(),
                u.getNome(),
                u.getEmail(),
                null, null, null);

        return new PostagemDTO(postagemSalva.getId(),
                postagemSalva.getTitulo(),
                postagemSalva.getConteudo(),
                postagemSalva.getData(),
                userDTO);
    }

    public List<Postagem> listaPostagens() {
        return postagemRepository.findAll();
    }

    public void deletarPostagem(Long postId) {
        postagemRepository.deleteById(postId);
    }


}

