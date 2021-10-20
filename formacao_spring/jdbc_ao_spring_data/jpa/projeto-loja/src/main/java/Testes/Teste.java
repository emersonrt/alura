package Testes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "teste")
@Entity
public class Teste implements Serializable {
    private static final long serialVersionUID = -8288872529851825273L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teste", nullable = false)
    private Long id;

    @Lob
    @Column(name = "decricao", nullable = false)
    private String decricao;

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teste)) return false;
        Teste teste = (Teste) o;
        return Objects.equals(getId(), teste.getId()) && Objects.equals(getDecricao(), teste.getDecricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDecricao());
    }

    @Override
    public String toString() {
        return "Teste{" +
                "id=" + id +
                ", decricao='" + decricao + '\'' +
                '}';
    }
}