package com.gusthavomnz.projetoBlog.dto;

import com.gusthavomnz.projetoBlog.model.Postagem;
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
    private UserDTO userDTO;


    public PostagemDTO(Long id, String titulo, String conteudo, LocalDateTime data, UserDTO userDTO) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.data = data;
        this.userDTO = userDTO;
    }

    public PostagemDTO(Postagem postagemSalva) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
