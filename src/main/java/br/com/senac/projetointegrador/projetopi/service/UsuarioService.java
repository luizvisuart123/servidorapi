package br.com.senac.projetointegrador.projetopi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import br.com.senac.projetointegrador.projetopi.dto.UsuarioDTO;
import br.com.senac.projetointegrador.projetopi.exception.NaoEncontradoException;
import br.com.senac.projetointegrador.projetopi.model.Usuario;
import br.com.senac.projetointegrador.projetopi.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    private UsuarioDTO convertDto(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDTO.class);
    }

    private Usuario convertFromDto(UsuarioDTO usuarioDto) {
        return this.modelMapper.map(usuarioDto, Usuario.class);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return this.usuarioRepository.findAll().stream()
                .map(this::convertDto)
                .collect(Collectors.toList());
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDto) {
        var usuario = this.convertFromDto(usuarioDto);
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        usuario.setActive(true);
        var savedUsuario = this.usuarioRepository.save(usuario);
        return this.convertDto(savedUsuario);
    }

    public Optional<UsuarioDTO> buscarPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email).map(this::convertDto);
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDto) {
        var usuario = this.usuarioRepository.findByEmail(usuarioDto.getEmail()).orElseThrow();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setPeso(usuarioDto.getPeso());
        usuario.setRoles(usuarioDto.getRoles());
        usuario.setNivelAtividadeFisica(usuarioDto.getNivelAtividadeFisica());
        usuario.setPassword(usuarioDto.getPassword());
        usuario.setAltura(usuarioDto.getAltura());
        return this.convertDto(usuarioRepository.save(usuario));
    }
    public Usuario getByUsernameEntity(String username) {
        return this.usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));
    }

	public void excluir(String username) {
        var usuario = this.usuarioRepository.findByUsername(username).orElseThrow();
        System.out.println(usuario);
        this.usuarioRepository.delete(usuario);
	}

}
