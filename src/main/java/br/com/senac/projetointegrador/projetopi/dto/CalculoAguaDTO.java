package br.com.senac.projetointegrador.projetopi.dto;

import java.time.LocalDate;

import br.com.senac.projetointegrador.projetopi.enumerador.NivelAtividadeFisica;
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
public class CalculoAguaDTO {
    private Long id;
    private Usuario usuario;
    private LocalDate dataCalculo;
    private int horasExercicioFisico; 
    private Double quantidadeIdealAgua;
    private boolean clima;
    
    //dados somente para alteração quando fazer o calculo da agua.
    private Double peso;
    private int idade;
    private NivelAtividadeFisica nivelAtividadeFisica;	
}
