package com.emersonrte.mvc.mudi.dto;

import com.emersonrte.mvc.mudi.model.Pedido;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RequisicaoNovoPedidoDto {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(this.nomeProduto);
        pedido.setUrlProduto(this.urlProduto);
        pedido.setUrlImagem(this.urlImagem);
        pedido.setDescricao(this.descricao);
        return pedido;
    }

}
