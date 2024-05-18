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

import br.com.senac.projetointegrador.projetopi.enumerador.NivelAtividadeFisica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "calculos_agua")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CalculoAgua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_calculo", nullable = false)
    private LocalDate dataCalculo;

    @Column(name = "quantidade_ideal_agua", nullable = false)
    private Double quantidadeIdealAgua;
    
    @Column(name = "horas_diaria_execicio", nullable = false)
    private int horasExercicioFisico; 
    
    @Column(name = "clima", nullable = false)
    private boolean clima;
    
    @Column(name = "peso", nullable = false)
    private Double peso;
    
    @Column(name = "idade", nullable = false)
    private int idade;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_atividade_fisica", nullable = false)	
    private NivelAtividadeFisica nivelAtividadeFisica;
    

}