package br.com.senac.projetointegrador.projetopi.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class User {
	
	@Id
	private Integer id;
	
	private String user;
	
	private String password;
	
	

}
