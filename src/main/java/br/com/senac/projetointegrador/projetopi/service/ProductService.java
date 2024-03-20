package br.com.senac.projetointegrador.projetopi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
    public List<String> getAllProducts() {
		  ArrayList<String> lista = new ArrayList<String>();
		  lista.add("luiz");
		  lista.add("carlos");
		  lista.add("santos");
		  lista.add("neto");
		  
		  return lista;
        // Lógica para buscar produtos do banco de dados ou outra fonte
        // Retorne uma lista de produtos
    }
    
    public String calculaIMC(double peso, double altura, String genero) {
    	double imc = calculateBMI(peso, altura);
    	String retorno = getBMICategory(imc, genero);
    	return retorno;
  
    }
    
    
    public double  calculateBMI(double peso, double altura) {
    	return peso / (altura * altura);
    }
    
    // Determina a categoria com base no IMC e no sexo
    public static String getBMICategory(double bmi, String genero) {
        if (bmi < 18.5) {
            return "Abaixo do peso";
        } else if (bmi < 24.9) {
            return "Peso normal";
        } else if (bmi < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }
}
