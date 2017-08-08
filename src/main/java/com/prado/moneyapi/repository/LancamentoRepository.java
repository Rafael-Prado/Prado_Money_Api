package com.prado.moneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prado.moneyapi.model.Lancamento;
import com.prado.moneyapi.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{

}
