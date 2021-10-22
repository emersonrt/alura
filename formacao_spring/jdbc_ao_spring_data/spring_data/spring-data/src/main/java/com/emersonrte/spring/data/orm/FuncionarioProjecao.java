package com.emersonrte.spring.data.orm;

import java.io.Serializable;
import java.math.BigDecimal;

public interface FuncionarioProjecao extends Serializable {

    Long getIdFuncionario();
    String getNome();
    BigDecimal getSalario();

}
