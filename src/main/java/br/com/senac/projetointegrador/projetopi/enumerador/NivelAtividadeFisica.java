package br.com.senac.projetointegrador.projetopi.enumerador;

public enum NivelAtividadeFisica {
    LEVE("Leve"),
    MODERADO("Moderado"),
    INTENSO("Intenso");

    private final String descricao;

    NivelAtividadeFisica(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
