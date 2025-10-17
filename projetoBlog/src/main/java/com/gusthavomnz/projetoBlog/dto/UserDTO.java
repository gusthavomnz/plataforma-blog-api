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
}
