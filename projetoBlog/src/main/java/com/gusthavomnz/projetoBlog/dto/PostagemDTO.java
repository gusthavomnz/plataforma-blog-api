package com.gusthavomnz.projetoBlog.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PostagemDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime data;

    public PostagemDTO(Long id, String titulo, String conteudo, LocalDateTime data) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
    }
}
