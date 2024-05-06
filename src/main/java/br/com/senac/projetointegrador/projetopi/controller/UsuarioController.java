package br.com.senac.projetointegrador.projetopi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.projetointegrador.projetopi.dto.UsuarioDTO;
import br.com.senac.projetointegrador.projetopi.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	private final UsuarioService service;
	
	
	//criar
    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir (@RequestBody UsuarioDTO dto) {
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }
	
	
	//ler
	@GetMapping
    public List<UsuarioDTO> listarTodos() {
        return this.service.listarUsuarios().stream()
                .collect(Collectors.toList());
    }
	
	
	//atualizar
	
	
	//excluir

	
}
