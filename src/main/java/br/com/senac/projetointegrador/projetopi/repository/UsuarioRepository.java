package br.com.senac.projetointegrador.projetopi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.projetointegrador.projetopi.model.Usuario;	

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsername(String username);
	public Optional<Usuario> findByEmail(String email);

}
