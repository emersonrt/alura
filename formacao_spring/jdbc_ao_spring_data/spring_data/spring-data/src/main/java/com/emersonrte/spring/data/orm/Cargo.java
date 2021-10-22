package com.emersonrte.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Table(name = "cargos")
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", nullable = false)
    private Long idCargo;
    private String descricao;
    @OneToMany(mappedBy = "cargo", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarioList;

    public Cargo() {
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "idCargo=" + idCargo +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}