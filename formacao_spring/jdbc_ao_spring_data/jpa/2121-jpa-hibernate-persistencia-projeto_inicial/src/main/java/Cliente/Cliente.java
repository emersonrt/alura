package Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "clientes")
@Entity
@NoArgsConstructor
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes", nullable = false)
    private Long idCliente;
    @Embedded
    private DadosPessoaisDto dadosPessoaisDto;

    public Cliente(String nome, String cpf) {
        this.dadosPessoaisDto = new DadosPessoaisDto(nome, cpf);
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return dadosPessoaisDto.getNome();
    }

    public String getCpf() {
        return dadosPessoaisDto.getCpf();
    }

    public void setNome(String nome) {
        this.dadosPessoaisDto.setNome(nome);
    }

    public void setCpf(String cpf) {
        this.dadosPessoaisDto.setCpf(cpf);
    }
}