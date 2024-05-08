package br.com.senac.projetointegrador.projetopi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.projetointegrador.projetopi.model.CalculoAgua;
import br.com.senac.projetointegrador.projetopi.model.Usuario;

public interface CalculoAguaRepository extends JpaRepository<CalculoAgua, Long> {

	List<CalculoAgua> findByUsuario(Usuario usuario);

}
