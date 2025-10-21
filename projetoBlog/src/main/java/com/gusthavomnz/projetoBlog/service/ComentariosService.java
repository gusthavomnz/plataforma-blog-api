package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.ComentariosDTO;
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
    public ComentariosDTO criarComentario(ComentariosDTO comentariosDTO, Long id, Long id_user){

        Comentarios novoComentario = new Comentarios();

        novoComentario.setComentario(comentariosDTO.getComentario());

        Postagem p = postagemRepository.findById(id).orElseThrow();
        Optional<User> u = userRepository.findById(id_user);
        novoComentario.setPostagem(p);
        novoComentario.setUsuario(u);

        Comentarios comentariosSalvo = comentariosRepository.save(novoComentario);
        return new ComentariosDTO(comentariosSalvo.getId(),
                comentariosSalvo.getComentario(),
                comentariosSalvo.getData(),
                comentariosDTO.getPostagemDTO(),
                comentariosDTO.getUserDTO());
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
