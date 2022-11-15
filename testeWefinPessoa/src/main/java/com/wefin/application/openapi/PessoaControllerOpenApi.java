package com.wefin.application.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wefin.application.representation.PessoaRequest;
import com.wefin.domain.Pessoa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PessoaControllerOpenApi {

	@Operation(summary = "Serviço de verificação de funcionamento da API", description = "Serviço de verificação de funcionamento da API")
    public String status();

	@Operation(summary = "Serviço de inclusão de pessoa", description = "Serviço de inclusão de pessoa")
	@ApiResponses({
		 @ApiResponse(responseCode = "201", description = "create"),
		 @ApiResponse(responseCode = "400", description = "Bad request"),
		 @ApiResponse(responseCode = "404", description = "Not found")
	})
	public ResponseEntity<?> salvar(@RequestBody(description = "Representação de uma pessoa") PessoaRequest pessoaRequest);
	
	@Operation(summary = "Serviço de recuperação de pessoa por identificador", description = "Serviço de recuperação de pessoa por identificador")
	@ApiResponses({
		 @ApiResponse(responseCode = "200", description = "sucess"),
		 @ApiResponse(responseCode = "400", description = "Bad request"),
		 @ApiResponse(responseCode = "404", description = "Not found")
	})
    public ResponseEntity<?> pegaPessoaPorIdentificador(@Parameter(description = "CPF ou CNPJ sem caracteres especiais", example = "85009474700", required = true) String identificador);
	
	@Operation(summary = "Serviço de recuperação de pessoa por id", description = "Serviço de recuperação de pessoa por id")
	@ApiResponses({
		 @ApiResponse(responseCode = "200", description = "sucess"),
		 @ApiResponse(responseCode = "400", description = "Bad request"),
		 @ApiResponse(responseCode = "404", description = "Not found")
	})
	public ResponseEntity<?> pegaPessoaPorId(@Parameter(description = "ID de uma pessoa", example = "1", required = true) Long id);
	
	@Operation(summary = "Serviço de listagem de pessoas", description = "Serviço de listagem de pessoas")
    public List<Pessoa> listar(); 
	
}
