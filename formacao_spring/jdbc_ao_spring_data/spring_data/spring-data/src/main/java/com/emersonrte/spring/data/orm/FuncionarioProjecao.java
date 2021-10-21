package com.emersonrte.spring.data.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public interface FuncionarioProjecao extends Serializable {

    Long getIdFuncionario();
    String getNome();
    BigDecimal getSalario();

}
