package com.lojachrist.loja_camisetas.controller;

import com.lojachrist.loja_camisetas.model.Produto;
import com.lojachrist.loja_camisetas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String paginaInicial(Model model) {
        // Vamos criar um produto de teste para aparecer na nossa loja agora mesmo!
        if (produtoRepository.count() == 0) {
            Produto camiseta = new Produto(
                    "Camiseta Oversized Cristã - Leão",
                    "100% Algodão penteado, fio 24.1, estampa em silk.",
                    89.90,
                    "G",
                    "Cristã",
                    "https://exemplo.com/foto.jpg"
            );
            produtoRepository.save(camiseta);
        }

        // Buscar todas as camisetas cadastradas no banco
        List<Produto> listaProdutos = produtoRepository.findAll();

        // Enviar a lista de produtos para a tela HTML
        model.addAttribute("produtos", listaProdutos);

        return "index"; // Vai procurar um arquivo chamado index.html
    }
}