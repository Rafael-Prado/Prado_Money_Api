package com.prado.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prado.moneyapi.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
