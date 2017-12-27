package br.com.davidlemos.backofficeME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.davidlemos.backofficeME.model.Pessoa;
import br.com.davidlemos.backofficeME.service.PessoaService;
import br.com.davidlemos.backofficeME.service.TokenService;


@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("cadastro")
	public String listaConvidados(Model model){
		model.addAttribute("msg", "");
		return "cadastro";
	}
	
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email")String email, 
			@RequestParam("telefone") String telefone, Model model){
		
		Pessoa novaPessoa = new Pessoa(nome, email, telefone);
		
		service.salvar(novaPessoa);		
		
		TokenService tokenService = new TokenService();
		String token = tokenService.gerarToken(novaPessoa.getEmail());		
		
		model.addAttribute("token", token);
		
		String infopessoa = service.selecionarPorEmail(novaPessoa.getEmail());
		model.addAttribute("pessoa", infopessoa);
		
		return "cadastro";
		
	}
	
}
