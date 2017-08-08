package com.prado.moneyapi.repository.lancamento;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prado.moneyapi.model.Lancamento;
import com.prado.moneyapi.repository.filter.LancamentoFilter;
import com.prado.moneyapi.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable page);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable page);
}
