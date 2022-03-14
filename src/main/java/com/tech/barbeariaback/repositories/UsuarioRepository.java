package com.tech.barbeariaback.repositories;

import com.tech.barbeariaback.models.Usuario;
import com.tech.barbeariaback.models.enums.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Transactional(readOnly = true)
    Usuario findByEmail(String email);
    @Transactional(readOnly = true)
    List<Usuario> findAllByPerfilDeUsuario(PerfilUsuario perfilUsuario);

}
