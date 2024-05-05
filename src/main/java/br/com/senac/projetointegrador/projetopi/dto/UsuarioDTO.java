package br.com.senac.projetointegrador.projetopi.dto;

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
    private String telefone;
    private String username;
    private String password;
    private String roles;

}
