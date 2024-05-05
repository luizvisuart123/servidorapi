package br.com.senac.projetointegrador.projetopi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.senac.projetointegrador.projetopi.enumerador.ClassificacaoIMC;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "calculos_imc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder	
public class CalculoIMC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_calculo", nullable = false)
    private LocalDate dataCalculo;

    @Column(name = "imc", nullable = false)
    private Double imc;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao_imc", nullable = false)
    private ClassificacaoIMC classificacaoIMC;

}
