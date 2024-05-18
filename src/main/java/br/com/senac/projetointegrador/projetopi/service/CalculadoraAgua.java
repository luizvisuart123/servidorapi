package br.com.senac.projetointegrador.projetopi.service;

import java.time.LocalDate;
import java.time.Period;

import br.com.senac.projetointegrador.projetopi.enumerador.NivelAtividadeFisica;
import br.com.senac.projetointegrador.projetopi.model.CalculoAgua;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculadoraAgua {
	
		
	public static double calcular(CalculoAgua calculoAgua) {

		// Calcular o consumo base de água
        double consumoBase = calculoAgua.getUsuario().getPeso() * 35;
        int idade = calcularIdade(calculoAgua.getUsuario().getDataNascimento());
        NivelAtividadeFisica nivelAtividadeFisica = calculoAgua.getUsuario().getNivelAtividadeFisica();
        int horasExercicio = calculoAgua.getHorasExercicioFisico();
        

        // Ajustar o consumo de água com base na idade
        if (idade <= 17) {
            consumoBase *= 1.1;
        } else if (idade >= 60) {
            consumoBase *= 0.8;
        }

        // Ajustar o consumo de água com base no nível de atividade física
        if(nivelAtividadeFisica.getDescricao().equalsIgnoreCase("Leve")){
        	consumoBase += horasExercicio * 100;
        }else if (nivelAtividadeFisica.getDescricao().equalsIgnoreCase("Moderado")) {
            consumoBase += horasExercicio * 500;
        } else if (nivelAtividadeFisica.getDescricao().equalsIgnoreCase("Intenso")) {
            consumoBase += horasExercicio * 1000;
        }

        // Ajustar o consumo de água com base no clima
        //"quente/seco" é true
        if (calculoAgua.isClima()) {
            consumoBase *= 1.2;
        }
        
        return consumoBase;
	}

	private static int calcularIdade(LocalDate dataNascimento) {
		// Obter a data atual
        LocalDate dataAtual = LocalDate.now();

        // Calcular o período entre a data de nascimento e a data atual
        Period periodo = Period.between(dataNascimento, dataAtual);

        // Extrair os anos do período
        int idadeEmAnos = periodo.getYears();

        // Verificar se ainda não chegou o aniversário do ano atual
        if (dataAtual.getMonthValue() < dataNascimento.getMonthValue() ||
                (dataAtual.getMonthValue() == dataNascimento.getMonthValue() &&
                        dataAtual.getDayOfMonth() < dataNascimento.getDayOfMonth())) {
            idadeEmAnos--;
        }
        return idadeEmAnos;
	}
}
