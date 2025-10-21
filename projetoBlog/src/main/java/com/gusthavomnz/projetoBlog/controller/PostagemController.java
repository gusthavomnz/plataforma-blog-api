package com.gusthavomnz.projetoBlog.controller;


import com.gusthavomnz.projetoBlog.dto.PostagemDTO;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.repository.ComentariosRepository;
import com.gusthavomnz.projetoBlog.repository.PostagemRepository;
import com.gusthavomnz.projetoBlog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gusthavomnz/blog")
public class PostagemController {


    @Autowired
    PostagemService postagemService;


    @PostMapping(value = "/post")
    public ResponseEntity<String> criarPostagem(@RequestBody PostagemDTO postagemDTO) {
        postagemService.criarPostagem(postagemDTO);
        return ResponseEntity.ok("Postagem feita!");
    }


    @GetMapping(value = "/post")
    public List<Postagem> postagens() {
        return postagemService.listaPostagens();
    }

    @DeleteMapping(value = "/post/{id}")
    public ResponseEntity<String> deletarPostagem(@PathVariable Long id){
        postagemService.deletarPostagem(id);
        return ResponseEntity.ok("Postagem Deletada!");
    }




}
