package com.wefin.application.representation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.wefin.application.groups.PessoaFisica;
import com.wefin.application.groups.PessoaJuridica;
import com.wefin.application.groups.PessoaRequestGroupSequenceProvider;
import com.wefin.domain.Pessoa;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@GroupSequenceProvider(value = PessoaRequestGroupSequenceProvider.class)
public class PessoaRequest {

	
	@Schema(example = "85009474700")
	@NotBlank(message = "informe o CPF ou CNPJ")
	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	private String identificador;
	
	@Schema(example = "Robson Costa")
	@NotBlank
	@Size(min = 3, max = 50, message = "Nome da pessoa deve ter entre 3 e 50 caracteres")
	private String nome;
	
	public Pessoa toModel() {
		return new Pessoa(identificador, nome);
	}
}
