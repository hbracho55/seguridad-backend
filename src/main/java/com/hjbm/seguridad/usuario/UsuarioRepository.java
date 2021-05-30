package com.hjbm.seguridad.usuario;

import com.hjbm.seguridad.persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT p FROM Usuario p WHERE p.email = ?1")
    Optional<Usuario> findPersonaByEmail(String email);
}
