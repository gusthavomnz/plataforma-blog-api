package com.gusthavomnz.projetoBlog.controller;


import com.gusthavomnz.projetoBlog.dto.ComentariosDTO;
import com.gusthavomnz.projetoBlog.model.Comentarios;
import com.gusthavomnz.projetoBlog.repository.ComentariosRepository;
import com.gusthavomnz.projetoBlog.service.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gusthavomnz/blog")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;


    @PostMapping(value = "{postId}/comentarios/{id_user}")
    public ResponseEntity<String> criarComentario(@PathVariable Long postId, @RequestBody ComentariosDTO comentariosDTO,@PathVariable Long id_user){
        comentariosService.criarComentario(comentariosDTO,postId, id_user);
        return ResponseEntity.ok("Comentario criado!");
    }


    @GetMapping(value = "{postId}/comentarios")
    public List<Comentarios> listaComentarios(@PathVariable Long postId){
        return comentariosService.buscarComentarios(postId);
    }

    @DeleteMapping(value = "{postId}/comentarios/{id_comentario}")
    public ResponseEntity<String> deletarComentario(@PathVariable Long id, @PathVariable Long id_comentario){
        comentariosService.deletarComentario(id_comentario);
       return ResponseEntity.ok("Comentario Deletado!");
    }







}
