package com.gusthavomnz.projetoBlog.controller;


import com.gusthavomnz.projetoBlog.dto.PostagemDTO;
import com.gusthavomnz.projetoBlog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
