package br.com.senac.projetointegrador.projetopi.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senac.projetointegrador.projetopi.dto.CalculoImcDTO;
import br.com.senac.projetointegrador.projetopi.model.CalculoIMC;
import br.com.senac.projetointegrador.projetopi.repository.CalculoImcRepository;
import br.com.senac.projetointegrador.projetopi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoIMCService {
	private final ModelMapper modelMapper;
	@SuppressWarnings("unused")
	private final PasswordEncoder passwordEncoder;
	private final CalculoImcRepository calculoImcRepository;
	private final UsuarioRepository usuarioRepository;
	
    private CalculoImcDTO convertDto(CalculoIMC calculoIMC) {
        return this.modelMapper.map(calculoIMC, CalculoImcDTO.class);
    }

    private CalculoIMC convertFromDto(CalculoImcDTO calculoImcDTO) {
        return this.modelMapper.map(calculoImcDTO, CalculoIMC.class);
    }

	public CalculoImcDTO salvar(CalculoImcDTO dto) {
        var calculoImc = this.convertFromDto(dto);
        var usuario = this.usuarioRepository.findByUsername(dto.getUsuario().getUsername());
        calculoImc.setUsuario(usuario.orElseThrow());
        var savedCalculoImc = this.calculoImcRepository.save(calculoImc);
        return this.convertDto(savedCalculoImc);
	}

	public List<CalculoImcDTO> listarCalculoImc() {
        return this.calculoImcRepository.findAll().stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
	}

	public void excluir(Long id) {
        var calculoImc = this.calculoImcRepository.findById(id).orElseThrow();
        System.out.println(calculoImc);
        this.calculoImcRepository.delete(calculoImc);
	}

	public Collection<CalculoImcDTO> listarCalculoAguaUsuario(String userName) {
		var usuario = this.usuarioRepository.findByUsername(userName);
		return calculoImcRepository.findByUsuario(usuario.orElseThrow());
	}

}
