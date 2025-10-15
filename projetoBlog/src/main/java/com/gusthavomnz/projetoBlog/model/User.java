package com.gusthavomnz.projetoBlog.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_usuarios")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comentarios> comentarios;

}
