package com.globalsysteste.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.globalsysteste.util.ApiError;

@Entity
@Table(name = "CEP")
public class Cep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String codLoja;

	private int faixaInicio;

	private int faixaFim;
	
	public Cep(ApiError apiError, HttpHeaders httpHeaders, HttpStatus status) {
		// TODO Auto-generated constructor stub
	}

	public Cep() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(String codLoja) {
		this.codLoja = codLoja;
	}

	public int getFaixaInicio() {
		return faixaInicio;
	}

	public void setFaixaInicio(int faixaInicio) {
		this.faixaInicio = faixaInicio;
	}

	public int getFaixaFim() {
		return faixaFim;
	}

	public void setFaixaFim(int faixaFim) {
		this.faixaFim = faixaFim;
	}


}
