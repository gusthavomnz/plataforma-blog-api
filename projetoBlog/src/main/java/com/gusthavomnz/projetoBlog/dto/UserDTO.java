package com.gusthavomnz.projetoBlog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
public class UserDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<ComentariosDTO> comentarios;
    private List<PostagemDTO> postagens;


    public UserDTO() {
    }

    public UserDTO(Long id, String nome, String email, String senha, List<ComentariosDTO> comentarios, List<PostagemDTO> postagens) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.comentarios = comentarios;
        this.postagens = postagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ComentariosDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentariosDTO> comentarios) {
        this.comentarios = comentarios;
    }

    public List<PostagemDTO> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<PostagemDTO> postagens) {
        this.postagens = postagens;
    }
}
