package com.gusthavomnz.projetoBlog.service;


import com.gusthavomnz.projetoBlog.dto.PostagemDTO;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {

    @Autowired
    PostagemRepository postagemRepository;


    public PostagemDTO criarPostagem(PostagemDTO postagemDTO) {
        Postagem novaPostagem = new Postagem();
        novaPostagem.setTitulo(postagemDTO.getTitulo());
        novaPostagem.setConteudo(postagemDTO.getConteudo());

        Postagem postagemSalva = postagemRepository.save(novaPostagem);

        return new PostagemDTO(postagemSalva.getId(),
                postagemSalva.getTitulo(),
                postagemSalva.getConteudo(),
                postagemSalva.getData());
    }

    public List<Postagem> listaPostagens() {
        return postagemRepository.findAll();
    }

    public void deletarPostagem(Long postId) {
        postagemRepository.deleteById(postId);
    }


}

