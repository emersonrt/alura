package com.emersonrte.mvc.mudi.controller;

import com.emersonrte.mvc.mudi.dto.RequisicaoNovoPedidoDto;
import com.emersonrte.mvc.mudi.model.Pedido;
import com.emersonrte.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedidoDto pedidoDto) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedidoDto pedidoDto, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = pedidoDto.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }

}
