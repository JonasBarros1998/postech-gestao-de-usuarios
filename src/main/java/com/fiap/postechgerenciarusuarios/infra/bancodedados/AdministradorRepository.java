package com.fiap.postechgerenciarusuarios.infra.bancodedados;

import com.fiap.postechgerenciarusuarios.dominio.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
}
