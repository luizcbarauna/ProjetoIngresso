package com.ingresso.ingresso.annotations;

import com.ingresso.ingresso.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface existsByEmail extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByEmail(String email);
}
