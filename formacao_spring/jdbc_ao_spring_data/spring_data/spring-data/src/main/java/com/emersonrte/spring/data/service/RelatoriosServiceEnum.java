package com.emersonrte.spring.data.service;

public enum RelatoriosServiceEnum {

    SAIR(0, "0 - Sair", "sair"),
    BUSCAR_FUNCIONARIO_NOME(1, "1 - Buscar funcionario nome", "buscarFuncionarioNome"),
    BUSCAR_FUNCIONARIO_NOME_SALARIO_MARIO_DATA(2, "2 - Buscar funcionario nome, salario e data contratação", "buscaFuncionarioNomeSalarioMaiorData"),
    BUSCAR_FUNCIONARIO_DATA_CONTRATACAO(3, "3 - Buscar funcionario data contratação", "buscaFuncionarioDataContratacao"),
    PESQUISA_FUNCIONARIO_SALARIO(4, "4 - Pesquisa funcionario salário", "pesquisaFuncionarioSalario");

    private Integer codigo;
    private String texto;
    private String methodName;

    RelatoriosServiceEnum(Integer codigo, String texto, String methodName) {
        this.codigo = codigo;
        this.texto = texto;
        this.methodName = methodName;
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

    public String getMethodName() {
        return methodName;
    }
}
