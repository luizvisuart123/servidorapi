package br.com.senac.projetointegrador.projetopi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.projetointegrador.projetopi.dto.CalculoImcDTO;
import br.com.senac.projetointegrador.projetopi.model.CalculoIMC;
import br.com.senac.projetointegrador.projetopi.model.Usuario;

public interface CalculoImcRepository extends JpaRepository<CalculoIMC, Long> {
	List<CalculoImcDTO> findByUsuario(Usuario orElseThrow);
}
