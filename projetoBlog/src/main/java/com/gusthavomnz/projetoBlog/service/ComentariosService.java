package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.ComentariosDTO;
import com.gusthavomnz.projetoBlog.dto.PostagemDTO;
import com.gusthavomnz.projetoBlog.dto.UserDTO;
import com.gusthavomnz.projetoBlog.model.Comentarios;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.model.User;
import com.gusthavomnz.projetoBlog.repository.ComentariosRepository;
import com.gusthavomnz.projetoBlog.repository.PostagemRepository;
import com.gusthavomnz.projetoBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariosService {

    @Autowired
    ComentariosRepository comentariosRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostagemRepository postagemRepository;



@Transactional
    public ComentariosDTO criarComentario(ComentariosDTO comentariosDTO, Long id_user, Long postId){

        Comentarios novoComentario = new Comentarios();

        novoComentario.setComentario(comentariosDTO.getComentario());

        Postagem p = postagemRepository.findById(postId).orElseThrow(); // ID DA POSTAGEM QUE IRA SER FEITA O COMENTARIO

       User u = userRepository.findById(id_user).orElseThrow(); // ID DE QUEM ESTÁ COMENTANDO

        novoComentario.setPostagem(p);
        novoComentario.setUsuario(u);

        Comentarios comentariosSalvo = comentariosRepository.save(novoComentario);


        // PROCESSO DE MAPEAR NOVAMENTE PARA DTO PARA FAZER O RETURN SEM PERIGO DE VAZAR DADOS:

    UserDTO autorDTO = new UserDTO(
            comentariosSalvo.getUsuario().getId(),
            comentariosSalvo.getUsuario().getNome(),
            comentariosSalvo.getUsuario().getEmail(),
            null, null, null // Garante que a senha não vaze
    );

    PostagemDTO postDTO = new PostagemDTO(
            comentariosSalvo.getPostagem().getId(),
            comentariosSalvo.getPostagem().getTitulo(),
            null, null, null);

    return new ComentariosDTO(
            comentariosSalvo.getId(),
            comentariosSalvo.getComentario(),
            comentariosSalvo.getData(),
            postDTO,
            autorDTO);
    }

    @Transactional
    public List<Comentarios> buscarComentarios(Long postId) {
    Optional<Postagem> p = postagemRepository.findById(postId);
    return p.get().getComentarios();
    }

    @Transactional
    public ResponseEntity<String> deletarComentario(Long comentarioId) {
    comentariosRepository.deleteById(comentarioId);
    return ResponseEntity.ok("Comentario Deletado!");
    }

}
