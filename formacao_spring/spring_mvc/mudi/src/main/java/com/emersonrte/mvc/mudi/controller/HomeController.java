package com.emersonrte.mvc.mudi.controller;

import com.emersonrte.mvc.mudi.model.Pedido;
import com.emersonrte.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final PedidoRepository pedidoRepository;

    public HomeController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

//    @GetMapping("/home")
//    public String home(Model model) {
//        List<Pedido> pedidos = pedidoRepository.findAll();
//        model.addAttribute("pedidos", pedidos);
//        return "home";
//    }

    @GetMapping("/home")
    public ModelAndView home() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }

}
