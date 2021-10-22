package com.emersonrte.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Table(name = "unidade_trabalho")
@Entity
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidade_trabalho", nullable = false)
    private Long idUnidadeTrabalho;
    private String descricao;
    private String endereco;
    @ManyToMany(mappedBy = "unidadeTrabalhoList", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarioList;

    public UnidadeTrabalho() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdUnidadeTrabalho() {
        return idUnidadeTrabalho;
    }

    public void setIdUnidadeTrabalho(Long idUnidadeTrabalho) {
        this.idUnidadeTrabalho = idUnidadeTrabalho;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public String toString() {
        return "UnidadeTrabalho{" +
                "idUnidadeTrabalho=" + idUnidadeTrabalho +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}