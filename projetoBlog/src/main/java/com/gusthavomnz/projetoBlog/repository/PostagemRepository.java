package com.gusthavomnz.projetoBlog.repository;

import com.gusthavomnz.projetoBlog.dto.ComentariosDTO;
import com.gusthavomnz.projetoBlog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
}
