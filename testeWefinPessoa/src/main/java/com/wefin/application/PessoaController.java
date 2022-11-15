package com.wefin.application;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wefin.application.representation.PessoaRequest;
import com.wefin.domain.Pessoa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor
@Slf4j
public class PessoaController {

	private final PessoaService pessoaService;
	
	@GetMapping("check")
    public String status(){
        log.info("Verificando o microserviço de pessoas");
        return "Microserviço de pessoas funcionando OK!";
    }

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid PessoaRequest pessoaRequest) {
	
		Pessoa pessoa = pessoaRequest.toModel();
		
		pessoa =  pessoaService.salvar(pessoa);
		
		URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("identificador={identificador}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        
		return ResponseEntity.created(headerLocation).build();
		
	}
	
}
