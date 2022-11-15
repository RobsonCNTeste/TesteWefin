package com.wefin.application.representation;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.wefin.application.groups.PessoaFisica;
import com.wefin.application.groups.PessoaJuridica;
import com.wefin.application.groups.PessoaRequestGroupSequenceProvider;
import com.wefin.domain.Pessoa;

import lombok.Data;

@Data
@GroupSequenceProvider(value = PessoaRequestGroupSequenceProvider.class)
public class PessoaRequest {

	@NotBlank(message = "informe o CPF ou CNPJ")
	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	private String identificador;
	
	@NotBlank
	private String nome;
	
	public Pessoa toModel() {
		return new Pessoa(identificador, nome);
	}
}
