package br.com.davidlemos.backofficeME.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.davidlemos.backofficeME.model.Pessoa;


public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
	
	public Pessoa findByEmail(String email);
		
}
