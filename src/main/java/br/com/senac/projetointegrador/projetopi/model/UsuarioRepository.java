package br.com.senac.projetointegrador.projetopi.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;	

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsername(String usuario);
	public Optional<Usuario> findByEmail(String email);

}
