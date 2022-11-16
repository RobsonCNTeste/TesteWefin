package com.wefin.domain.groups;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.wefin.application.groups.PessoaFisica;
import com.wefin.application.groups.PessoaJuridica;
import com.wefin.domain.Pessoa;

public class PessoaGroupSequenceProvider implements DefaultGroupSequenceProvider<Pessoa>{
	
	@Override
	public List<Class<?>> getValidationGroups(Pessoa pessoa) {
	    
		List<Class<?>> groups = new ArrayList<>();
	    
		groups.add(Pessoa.class);
	    
		if (pessoa != null && pessoa.getIdentificador() != null) {
			
			if ("CPF".equalsIgnoreCase(pessoa.getTipoIdentificador().name()) ) {
				groups.add(PessoaFisica.class);
			} else if ("CNPJ".equalsIgnoreCase(pessoa.getTipoIdentificador().name()) ) {
				groups.add(PessoaJuridica.class);
			}
		}
				
		return groups;
	}

}
