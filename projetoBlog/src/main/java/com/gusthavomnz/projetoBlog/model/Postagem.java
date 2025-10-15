package com.gusthavomnz.projetoBlog.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String conteudo;
    private LocalDateTime data;

    private List<Comentarios> comentarios;

    private User usuario;

}
