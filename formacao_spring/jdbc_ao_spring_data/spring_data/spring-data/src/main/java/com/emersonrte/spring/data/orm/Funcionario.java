package com.emersonrte.spring.data.orm;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "funcionario")
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario", nullable = false)
    private Long idFuncionario;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private LocalDate dataContratacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "funcionario_unidade_trabalho",
            joinColumns = {@JoinColumn(name = "fk_funcionario")},
            inverseJoinColumns = {@JoinColumn(name = "fk_unidade")}
    )
    private List<UnidadeTrabalho> unidadeTrabalhoList;

    public Funcionario() {
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<UnidadeTrabalho> getUnidadeTrabalhoList() {
        return unidadeTrabalhoList;
    }

    public void setUnidadeTrabalhoList(List<UnidadeTrabalho> unidadeTrabalhoList) {
        this.unidadeTrabalhoList = unidadeTrabalhoList;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo.getDescricao() +
                '}';
    }
}