package org.example;

import org.example.model.Product;
import org.example.scraper.Scraper;
import org.example.util.JsonUtil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir link");
            System.out.println("2 - Usar link padrão");
            System.out.println("3 - Sair");

            String opcao = scanner.nextLine();

            String url = "";

            if (opcao.equals("1")) {
                System.out.println("Digite o link da Netshoes:");
                url = scanner.nextLine();

            } else if (opcao.equals("2")) {
                url = "https://www.netshoes.com.br/p/camisa-brasil-nike-i-202627-torcedor-pro-masculina-SGL-0522-046";

            } else if (opcao.equals("3")) {
                System.out.println("Encerrando...");
                break;

            } else {
                System.out.println("Opção inválida.");
                continue;
            }

            try {
                validarUrl(url);

                Scraper scraper = new Scraper();
                Product produto = scraper.extrairProduto(url);

                String json = JsonUtil.toJson(produto);
                System.out.println(json);

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Erro ao processar o link.");
            }
        }

        scanner.close();
    }

    private static void validarUrl(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL vazia.");
        }

        if (!url.contains("netshoes.com.br")) {
            throw new IllegalArgumentException("O link deve ser da Netshoes.");
        }

        if (!url.contains("/p/")) {
            throw new IllegalArgumentException("Link não parece ser de um produto.");
        }
    }
}