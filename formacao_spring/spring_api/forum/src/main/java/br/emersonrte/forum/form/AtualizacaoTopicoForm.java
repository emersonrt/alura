package br.emersonrte.forum.form;

import br.emersonrte.forum.model.Topico;
import br.emersonrte.forum.repository.TopicoRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class AtualizacaoTopicoForm {

    @NotBlank @Length(min = 5)
    private String titulo;

    @NotBlank @Length(min = 5)
    private String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getById(id);

        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
