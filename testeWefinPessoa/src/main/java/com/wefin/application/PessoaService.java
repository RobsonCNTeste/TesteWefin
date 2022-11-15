package com.wefin.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wefin.application.exception.PessoaJaCadastradaException;
import com.wefin.domain.Pessoa;
import com.wefin.domain.TipoIdentificador;
import com.wefin.infra.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

	private final Integer TAMANHO_CPF = 11;
	private final Integer TAMANHO_CNPJ = 14;
	
	private final PessoaRepository pessoaRepository;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		
		Optional<Pessoa> optionalPessoa = pessoaRepository.findByIdentificador(pessoa.getIdentificador());
		if (optionalPessoa.isPresent()) {
			throw new PessoaJaCadastradaException(String.format("Pessoa com o identificador %s já existe", pessoa.getIdentificador()));
		}
		
		TipoIdentificador tipoIdentificador = tipoIdentificadorFactory(pessoa.getIdentificador());

		pessoa.setTipoIdentificador(tipoIdentificador);
		
		return pessoaRepository.save(pessoa);
	}

	private TipoIdentificador tipoIdentificadorFactory(String identificador) {
		
		TipoIdentificador tipoIdentificador = null;		
		
		if (identificador !=null) {
			if (identificador.length() <= TAMANHO_CPF ) {
				tipoIdentificador = TipoIdentificador.CPF;
			} else if (identificador.length() <= TAMANHO_CNPJ ) {
				tipoIdentificador = TipoIdentificador.CNPJ;
			}
		}
		
		return tipoIdentificador;
	}
	
}
