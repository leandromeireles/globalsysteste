package com.globalsysteste.models;

import java.io.Serializable;

public class CepResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cod;

	private String message;

	private String lojaFisica;

	public static final String STATUS_204 = "204";

	public static final String STATUS_201_SUCCESS = "201";

	public static final String MSG_201_GET = "Cep consultado com sucesso";

	public static final String MSG_204_POST = "Cep ja esta em area de cobertura";

	public static final String MSG_204_GET = "Cep não esta em area de cobertura";

	public static final String MSG_201 = "201";

	public static final String MSG_ERROR = "Erro ao buscar cep";

	private Cep cep;

	public String getCod() {
		return cod;
	}

	public void setCod(String status204) {
		this.cod = status204;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLojaFisica() {
		return lojaFisica;
	}

	public void setLojaFisica(String lojaFisica) {
		this.lojaFisica = lojaFisica;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

}
