package org.example;

import org.example.model.Product;
import org.example.scraper.Scraper;
import org.example.util.JsonUtil;

public class Main {

    public static void main(String[] args) {

        Scraper scraper = new Scraper();

        Product produto = scraper.extrairProduto(
                "https://www.netshoes.com.br/p/maio-macaquinho-natacao-trinys-3620-estampado-sl2654-BAE-06BN-060"
        );

        String json = JsonUtil.toJson(produto);

        System.out.println(json);
    }
}