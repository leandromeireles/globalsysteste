package com.globalsysteste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globalsysteste.models.Cep;

public interface CepRepository extends JpaRepository<Cep, Long> {
	
	Cep findById(long id);

	@Query("select c from Cep c where c.faixaInicio between :faixaInicio  and :faixaFim")
	List<Cep> findByStarCepBetween(@Param("faixaInicio")int faixaInicio, @Param("faixaFim")int faixaFim);
	
	
	@Query("select c from Cep c where c.faixaFim between :faixaInicio and :faixaFim")
	List<Cep> findByEndCepBetween(@Param("faixaInicio")int faixaInicio, @Param("faixaFim")int faixaFim);
	
	
	@Query("select c from Cep c where :cep between c.faixaInicio and  c.faixaFim")
	Cep findCep(@Param("cep")int cep);
}
