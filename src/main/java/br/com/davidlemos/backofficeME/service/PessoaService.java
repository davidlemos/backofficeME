package br.com.davidlemos.backofficeME.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.davidlemos.backofficeME.model.Pessoa;
import br.com.davidlemos.backofficeME.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
		
	public void salvar(Pessoa pessoas){
		repository.save(pessoas);
	}	
	
	public String selecionarPorEmail(String email) {
		String infoPessoa= "";		
		try{
			Pessoa pessoa = repository.findByEmail(email);
			infoPessoa = pessoa.getInfoPessoa();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return infoPessoa;
	}
	
}
