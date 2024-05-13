package br.com.senac.projetointegrador.projetopi.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.projetointegrador.projetopi.login.AuthRequest;
import br.com.senac.projetointegrador.projetopi.model.Usuario;
import br.com.senac.projetointegrador.projetopi.repository.UsuarioRepository;
import br.com.senac.projetointegrador.projetopi.service.JwtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class AuthRestController {
	
	private final UsuarioRepository usuarioRepository;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
	
    @PostMapping
    public String login(@RequestBody AuthRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        this.authenticationManager.authenticate(authentication);
        Usuario usuario = this.usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        return this.jwtService.createToken(usuario);
    }

}
