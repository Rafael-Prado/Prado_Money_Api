package com.prado.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prado.moneyapi.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
