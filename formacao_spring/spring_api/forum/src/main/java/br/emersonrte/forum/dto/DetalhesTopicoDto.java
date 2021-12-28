package br.emersonrte.forum.dto;

import br.emersonrte.forum.model.StatusTopico;
import br.emersonrte.forum.model.Topico;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DetalhesTopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaDto> respostaList;

    public DetalhesTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor() != null ? topico.getAutor().getNome() : null;
        this.status = topico.getStatus();
        this.respostaList = new ArrayList<>();
        this.respostaList.addAll(topico.getRespostas()
                .stream()
                .map(RespostaDto::new)
                .collect(Collectors.toList())
        );
    }
}
