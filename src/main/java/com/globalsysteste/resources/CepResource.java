package com.globalsysteste.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globalsysteste.models.Cep;
import com.globalsysteste.repository.CepRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API GLOBALSYS TESTE")
@CrossOrigin(origins = "*")
public class CepResource extends ResponseEntityExceptionHandler {

	@Autowired
	CepRepository cepRepository;

	@GetMapping("/cep")
	@ApiOperation(value = "Retorna Lista de Cep")
	public List<Cep> listaCep() {

		return cepRepository.findAll();

	}

	@GetMapping("/cep/{cep}")
	@ApiOperation(value = "Retorna Loja Física")
	public Object buscaCep(@PathVariable(value = "cep") int cep) throws Exception {

		try {
			Cep cepGet = new Cep();
			cepGet = betweenCep(cep);

			if (cepGet == null) {

				String error = "Cep não esta em area de cobertura";


				return new HttpClientErrorException(HttpStatus.NOT_FOUND , error);
			}			
			
			return cepGet;
		} catch (Exception e) {

			throw new Exception("Erro ao buscar cep.", e);

		}

	}

	@PostMapping("/cep")
	@ApiOperation(value = "Salva um Cep")
	public Object salvaCep(@RequestBody Cep cep) throws Exception {

		try {
			List<Cep> cepGet = new ArrayList<>();
			cepGet = cepRepository.findAll();

			if (cepGet.isEmpty()) {

				return cepRepository.save(cep);
			}

			if (!between(cep)) {

				String error = "Cep ja esta em area de cobertura";

				return new HttpClientErrorException(HttpStatus.NOT_FOUND , error);

							}

			return cepRepository.save(cep);
		} catch (Exception e) {

			throw new Exception("Erro ao persistir objeto.", e);

		}

	}

	@DeleteMapping("/cep")
	@ApiOperation(value = "Deleta um Cep")
	public void deletaCep(@RequestBody Cep cep) {

		cepRepository.delete(cep);

	}

	@PutMapping("/cep")
	@ApiOperation(value = "Atualiza Cep")
	public Object atualizaCep(@RequestBody Cep cep) throws Exception {

		try {
			List<Cep> cepGet = new ArrayList<>();
			cepGet = cepRepository.findAll();

			if (cepGet.isEmpty()) {

				return cepRepository.save(cep);
			}

			if (!between(cep)) {

				String error = "Cep ja esta em area de cobertura";

				return new HttpClientErrorException(HttpStatus.NOT_FOUND , error);
			}

			return cepRepository.save(cep);
		} catch (Exception e) {

			throw new Exception("Erro ao persistir objeto.", e);

		}
	}

	private boolean between(Cep cep) {

		List<Cep> listaCep = new ArrayList<>();

		listaCep = cepRepository.findByStarCepBetween(cep.getFaixaInicio(), cep.getFaixaFim());

		if (listaCep.isEmpty()) {

			return true;
		} else {

			return false;
		}

	}
	private Cep betweenCep(int cep) {

		Cep cepFind = new Cep();

		cepFind = cepRepository.findCep(cep);

		return cepFind;

	}

}
