package com.fiap.postechgerenciarusuarios.infra.bancodedados;

import com.fiap.postechgerenciarusuarios.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	Optional<Usuario> findBySub(String email);
}
