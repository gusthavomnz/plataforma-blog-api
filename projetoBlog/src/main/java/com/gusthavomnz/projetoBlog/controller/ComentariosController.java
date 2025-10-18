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

    private ComentariosRepository comentariosRepository;



    @PostMapping(value = "/comentarios")
    public ResponseEntity<String> criarComentario(@RequestBody ComentariosDTO comentariosDTO){
        comentariosService.criarComentario(comentariosDTO);
        return ResponseEntity.ok("Comentario criado!");
    }


    @GetMapping(value = "/comentarios")
    public List<Comentarios> listaComentarios(){
        return comentariosRepository.findAll();
    }







}
