package br.com.senac.projetointegrador.projetopi.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senac.projetointegrador.projetopi.dto.CalculoAguaDTO;
import br.com.senac.projetointegrador.projetopi.dto.CalculoImcDTO;
import br.com.senac.projetointegrador.projetopi.model.CalculoAgua;
import br.com.senac.projetointegrador.projetopi.repository.CalculoAguaRepository;
import br.com.senac.projetointegrador.projetopi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculoAguaService {
	private final ModelMapper modelMapper;
	@SuppressWarnings("unused")
	private final PasswordEncoder passwordEncoder;
	private final CalculoAguaRepository calculoAguaRepository;
	private final UsuarioRepository usuarioRepository;

	
    private CalculoAguaDTO convertDto(CalculoAgua calculoAgua) {
        return this.modelMapper.map(calculoAgua, CalculoAguaDTO.class);
    }

    private CalculoAgua convertFromDto(CalculoAguaDTO calculoImcDTO) {
        return this.modelMapper.map(calculoImcDTO, CalculoAgua.class);
    }
    
	public CalculoAguaDTO salvar(CalculoAguaDTO dto) {
        var calculoAgua = this.convertFromDto(dto);
        var usuario = this.usuarioRepository.findByUsername(dto.getUsuario().getUsername());
        calculoAgua.setUsuario(usuario.orElseThrow());
        var savedCalculoAgua = this.calculoAguaRepository.save(calculoAgua);
        return this.convertDto(savedCalculoAgua);
	}

	public Collection<CalculoAguaDTO> listarCalculoImc() {
        return this.calculoAguaRepository.findAll().stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
	}

	public void excluir(Long id) {
        var calculoAgua = this.calculoAguaRepository.findById(id).orElseThrow();
        System.out.println(calculoAgua);
        this.calculoAguaRepository.delete(calculoAgua);		
	}

}
