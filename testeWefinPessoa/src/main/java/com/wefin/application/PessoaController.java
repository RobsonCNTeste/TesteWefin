package com.wefin.application;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wefin.application.openapi.PessoaControllerOpenApi;
import com.wefin.application.representation.PessoaRequest;
import com.wefin.domain.Pessoa;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Tag(name = "Pessoas", description = "Operações com pessoas")
@RequestMapping("pessoas")
@RequiredArgsConstructor
@Slf4j
public class PessoaController implements PessoaControllerOpenApi{

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
	
	@GetMapping(params = "identificador")
    public ResponseEntity<?> pegaPessoaPorIdentificador(@RequestParam String identificador) {
		
		Pessoa pessoa = pessoaService.pegaPessoaPorIdentificador(identificador);
		
		return ResponseEntity.ok(pessoa);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pegaPessoaPorId(@PathVariable Long id) {
		
		Pessoa pessoa = pessoaService.pegaPessoaPorId(id);
		
		return ResponseEntity.ok(pessoa);
		
	}
	
	@GetMapping("relatorio")
    public List<Pessoa> listar() {
		return pessoaService.listar();
	}
	
}
