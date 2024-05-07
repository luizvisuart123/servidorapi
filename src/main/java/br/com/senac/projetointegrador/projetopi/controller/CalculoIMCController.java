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

import br.com.senac.projetointegrador.projetopi.dto.CalculoImcDTO;
import br.com.senac.projetointegrador.projetopi.service.CalculoIMCService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/calculo_imc")
@RequiredArgsConstructor
public class CalculoIMCController {
	private final CalculoIMCService service;

	//criar
    @PostMapping
    public ResponseEntity<CalculoImcDTO> inserir (@RequestBody CalculoImcDTO dto) {
        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }
	
	//ler
	@GetMapping
    public List<CalculoImcDTO> listarTodos() {
        return this.service.listarCalculoImc().stream()
                .collect(Collectors.toList());
    }
//	
//	
//	//atualizar
//    @PutMapping("/{username}")
//    public ResponseEntity<UsuarioDTO> atualizar (@PathVariable("username") String username, @RequestBody UsuarioDTO dto) {
//        dto.setUsername(username);
//        return new ResponseEntity<>(this.service.atualizar(dto), HttpStatus.OK);
//    }	
//	
//	//excluir
//    @DeleteMapping("/{username}")
//    public ResponseEntity excluir (@PathVariable("username") String username) {
//        service.excluir(username);
//        return ResponseEntity.noContent().build();
//    }
}
