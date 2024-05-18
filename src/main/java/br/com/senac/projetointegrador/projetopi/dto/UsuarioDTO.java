package br.com.senac.projetointegrador.projetopi.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.senac.projetointegrador.projetopi.enumerador.NivelAtividadeFisica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import org.hibernate.validator.constraints.br.CPF;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDTO {
//    @NotBlank
    private String nome;
//    @Email(message = "email invalido")
    private String email;
    private String senha;
    private String username;
    private String password;
    private String roles;
    private Double peso;
    private Double altura;
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_atividade_fisica", nullable = false)
    private NivelAtividadeFisica nivelAtividadeFisica;	
    private LocalDate dataNascimento;

}
