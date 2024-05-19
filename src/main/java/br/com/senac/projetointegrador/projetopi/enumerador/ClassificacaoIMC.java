package br.com.senac.projetointegrador.projetopi.enumerador;

public enum ClassificacaoIMC {
	MAGREZA("Magreza"),
	NORMAL("Normal"),
	SOBREPESO("Sobrepeso"),
    OBESIDADE1("Obesidade grau I"),
    OBESIDAD2("Obesidade grau II"),
    OBESIDADE3("Obesidade grau III");
	

    private final String descricao;

    ClassificacaoIMC(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
    	System.out.println(descricao);
        return descricao;
    }

}
