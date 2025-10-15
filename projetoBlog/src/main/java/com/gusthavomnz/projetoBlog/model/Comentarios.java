package com.gusthavomnz.projetoBlog.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "tb_comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comentario;
    private LocalDateTime data;

@ManyToOne
    private Postagem postagem;

@ManyToOne
    private User usuario;



}
