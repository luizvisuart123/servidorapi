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

import br.com.senac.projetointegrador.projetopi.dto.CalculoAguaDTO;
import br.com.senac.projetointegrador.projetopi.dto.CalculoImcDTO;
import br.com.senac.projetointegrador.projetopi.service.CalculoAguaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/calculo_agua")
@RequiredArgsConstructor
public class CalculoAguaController {
	private final CalculoAguaService service;

	//criar
    @PostMapping
    public ResponseEntity<CalculoAguaDTO> inserir (@RequestBody CalculoAguaDTO dto) {
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }
    
	//ler
	@GetMapping
    public List<CalculoAguaDTO> listarTodos() {
		return this.service.listarCalculoImc().stream()
                .collect(Collectors.toList());
    }
}
