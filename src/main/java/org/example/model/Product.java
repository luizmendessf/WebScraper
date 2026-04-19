package org.example.model;

public class Product {
    private String titulo;
    private String preco;
    private String imagem;
    private String descricao;

    public Product(String titulo, String preco, String imagem, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public String getTitulo() { return titulo; }
    public String getPreco() { return preco; }
    public String getImagem() { return imagem; }
    public String getDescricao() { return descricao; }
}

