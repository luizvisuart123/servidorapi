package br.com.senac.projetointegrador.projetopi.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {
	private static final long serialVersionUID = -1615268945588783905L;

	public AbstractException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();
}
