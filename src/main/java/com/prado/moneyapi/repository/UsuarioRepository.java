package com.prado.moneyapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prado.moneyapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);

}
