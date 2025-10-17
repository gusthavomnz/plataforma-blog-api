package com.gusthavomnz.projetoBlog.repository;

import com.gusthavomnz.projetoBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
