package com.wefin.application.exception;

public abstract class EntidadeJaExisteException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeJaExisteException(String mensagem) {
		super(mensagem);
	}
	
}
