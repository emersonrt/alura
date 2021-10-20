package Pedido;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class RelatorioDeVendasDto {

    private final String nomeProduto;
    private final Long quantidadeVendida;
    private final LocalDate dataUltimaVenda;

}
