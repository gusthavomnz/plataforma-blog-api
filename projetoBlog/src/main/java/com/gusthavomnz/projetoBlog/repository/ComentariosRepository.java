package com.gusthavomnz.projetoBlog.repository;

import com.gusthavomnz.projetoBlog.model.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
}
