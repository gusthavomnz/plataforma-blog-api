package com.gusthavomnz.projetoBlog.dto;

import com.gusthavomnz.projetoBlog.model.Comentarios;
import com.gusthavomnz.projetoBlog.model.Postagem;
import com.gusthavomnz.projetoBlog.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ComentariosDTO {

    private Long id;
    private String comentario;
    private LocalDateTime data;
    private PostagemDTO postagemDTO;
    private UserDTO userDTO;

    public ComentariosDTO(Long id, String comentario, LocalDateTime data, PostagemDTO postagemDTO, UserDTO userDTO) {
        this.comentario = comentario;
        this.data = null;
        this.postagemDTO = postagemDTO;
        this.userDTO = userDTO;
    }

    public ComentariosDTO(Comentarios comentariosSalvo) {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public PostagemDTO getPostagemDTO() {
        return postagemDTO;
    }

    public void setPostagemDTO(PostagemDTO postagemDTO) {
        this.postagemDTO = postagemDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
