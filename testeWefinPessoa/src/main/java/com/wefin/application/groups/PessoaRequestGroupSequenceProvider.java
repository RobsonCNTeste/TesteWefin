package com.wefin.application.groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.wefin.application.representation.PessoaRequest;

public class PessoaRequestGroupSequenceProvider implements DefaultGroupSequenceProvider<PessoaRequest>{

	private final Integer TAMANHO_CPF = 11;
	private final Integer TAMANHO_CNPJ = 14;
	
	@Override
	public List<Class<?>> getValidationGroups(PessoaRequest pessoaRequest) {
	    
		List<Class<?>> groups = new ArrayList<>();
	    
		groups.add(PessoaRequest.class);
	    
		if (pessoaRequest != null && pessoaRequest.getIdentificador() != null) {
			
			if (pessoaRequest.getIdentificador().length() <= TAMANHO_CPF ) {
				groups.add(PessoaFisica.class);
			} else if (pessoaRequest.getIdentificador().length() >= TAMANHO_CNPJ) {
				groups.add(PessoaJuridica.class);
			}
		}
				
		return groups;
	}

}
