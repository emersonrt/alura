package com.emersonrte.spring.data.service;

public enum RelatoriosServiceEnum {

    SAIR(0, "0 - Sair"),
    BUSCAR_FUNCIONARIO_NOME(1, "1 - Buscar funcionario nome"),
    BUSCAR_FUNCIONARIO_NOME_SALARIO_MARIO_DATA(2, "2 - Buscar funcionario nome, salario e data contratação"),
    BUSCAR_FUNCIONARIO_DATA_CONTRATACAO(3, "3 - Buscar funcionario data contratação"),
    PESQUISA_FUNCIONARIO_SALARIO(4, "4 - Pesquisa funcionario salário");

    private Integer codigo;
    private String texto;

    RelatoriosServiceEnum(int codigo, String texto) {
        this.codigo = codigo;
        this.texto = texto;
    }

    public static RelatoriosServiceEnum getActionByCodigo(Integer id) {
        for(RelatoriosServiceEnum e : values()) {
            if(e.codigo.equals(id)) return e;
        }
        return SAIR;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTexto() {
        return texto;
    }
}
