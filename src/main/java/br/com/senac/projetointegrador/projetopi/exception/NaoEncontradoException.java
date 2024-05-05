package br.com.senac.projetointegrador.projetopi.exception;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends AbstractException{
	private static final long serialVersionUID = 5572564083355431142L;

	public NaoEncontradoException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
