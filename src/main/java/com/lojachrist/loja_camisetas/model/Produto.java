package com.lojachrist.loja_camisetas.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Diz ao Spring que essa classe vai virar uma tabela no banco de dados
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Double preco;
    private String tamanho; // Ex: P, M, G, GG
    private String categoria; // Ex: "Cristã" ou "Lisa"
    private String imagemUrl;

    // Construtor vazio (obrigatório para o JPA)
    public Produto() {
    }

    // Construtor com campos
    public Produto(String nome, String descricao, Double preco, String tamanho, String categoria, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getImagemUrl() { return imagemUrl; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }
}
