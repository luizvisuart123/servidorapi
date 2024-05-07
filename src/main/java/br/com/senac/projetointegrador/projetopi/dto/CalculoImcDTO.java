package br.com.senac.projetointegrador.projetopi.dto;

import java.time.LocalDate;

import br.com.senac.projetointegrador.projetopi.enumerador.ClassificacaoIMC;
import br.com.senac.projetointegrador.projetopi.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CalculoImcDTO {
    private Long id;
    private Usuario usuario;
    private LocalDate dataCalculo;
    private Double imc;
    private ClassificacaoIMC classificacaoIMC;

}
