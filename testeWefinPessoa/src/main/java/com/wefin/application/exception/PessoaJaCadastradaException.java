package com.wefin.application.exception;

public class PessoaJaCadastradaException extends EntidadeJaExisteException {

	private static final long serialVersionUID = 1L;

	public PessoaJaCadastradaException(String mensagem) {
		super(mensagem);
	}
	
	public PessoaJaCadastradaException(Long pessoaId) {
		this(String.format("Não existe um cadastro de pessoa com código %d", pessoaId));
	}
	
}
