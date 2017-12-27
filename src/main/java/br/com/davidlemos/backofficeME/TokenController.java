package br.com.davidlemos.backofficeME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.davidlemos.backofficeME.service.PessoaService;

@Controller
public class TokenController {
	@Autowired
	private PessoaService service;
	
	
	@RequestMapping(value = "/infopessoa")
	public ResponseEntity<String> getInfoPessoaPorEmail (@RequestParam("email") String email)
	{
		
		String pessoa = service.selecionarPorEmail(email);
	
	   if(!pessoa.isEmpty()) {	       
	        return new ResponseEntity<String>(pessoa, HttpStatus.OK);
	    }
	   else {
		   return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	   }
	}

}
