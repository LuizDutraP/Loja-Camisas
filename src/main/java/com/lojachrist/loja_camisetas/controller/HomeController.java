package com.lojachrist.loja_camisetas.controller;

import com.lojachrist.loja_camisetas.model.Produto;
import com.lojachrist.loja_camisetas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String paginaInicial(Model model) {
        // Se o banco estiver vazio, cria o produto de exemplo de ontem
        if (produtoRepository.count() == 0) {
            Produto camiseta = new Produto(
                    "Camiseta Oversized Cristã - Leão",
                    "100% Algodão penteado, fio 24.1, estampa em silk.",
                    89.90,
                    "G",
                    "Cristã",
                    "https://images.unsplash.com/photo-1521572267360-ee0c2909d518?auto=format&fit=crop&w=600&q=80"
            );
            produtoRepository.save(camiseta);
        }

        List<Produto> listaProdutos = produtoRepository.findAll();
        model.addAttribute("produtos", listaProdutos);
        return "index";
    }

    // Método para abrir a página do formulário de cadastro
    @GetMapping("/produtos/novo")
    public String formularioNovoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "novo-produto";
    }

    // Método para salvar o produto enviado pelo formulário
    @PostMapping("/produtos/salvar")
    public String salvarProduto(Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/"; // Redireciona de volta para a página inicial
    }
    // Método para exibir a página de detalhes de um produto específico
    @GetMapping("/produto/{id}")
    public String detalhesProduto(@PathVariable Long id, Model model) {
        // Busca o produto no banco pelo ID, se não achar, retorna para a home
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto == null) {
            return "redirect:/";
        }

        model.addAttribute("produto", produto);
        return "detalhes-produto";
    }
}