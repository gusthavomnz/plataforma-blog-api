package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.ComentariosDTO;
import com.gusthavomnz.projetoBlog.model.Comentarios;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.model.User;
import com.gusthavomnz.projetoBlog.repository.ComentariosRepository;
import com.gusthavomnz.projetoBlog.repository.PostagemRepository;
import com.gusthavomnz.projetoBlog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComentariosService {

    ComentariosRepository comentariosRepository;
    UserRepository userRepository;
    PostagemRepository postagemRepository;




    public ComentariosDTO criarComentario(ComentariosDTO comentariosDTO){

        Comentarios novoComentario = new Comentarios();
        Long idPostagem = comentariosDTO.getPostagemDTO().getId();

        novoComentario.setComentario(comentariosDTO.getComentario());
        novoComentario.setData(comentariosDTO.getData());

        Postagem p = postagemRepository.findById(idPostagem).orElseThrow();
        User u = p.getUsuario();

        novoComentario.setPostagem(p);
        novoComentario.setUsuario(u);

        Comentarios comentariosSalvo = comentariosRepository.save(novoComentario);
        return new ComentariosDTO(comentariosSalvo.getId(),
                comentariosSalvo.getComentario(),
                comentariosSalvo.getData(),
                comentariosDTO.getPostagemDTO(),
                comentariosDTO.getUserDTO());


    }
}
