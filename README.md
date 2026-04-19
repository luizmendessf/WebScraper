# Web Scraper - Netshoes

## Sobre o projeto

Este projeto foi desenvolvido como parte de um case para vaga de estágio em desenvolvimento back-end.

O objetivo é realizar uma requisição a uma página de produto do site da Netshoes e extrair informações relevantes diretamente do HTML.

Para isso, foi utilizado Selenium com Java, simulando o comportamento de um usuário no navegador para lidar com conteúdo dinâmico.

Além disso, foi implementado um menu interativo no terminal para permitir diferentes formas de execução.

---

## Objetivo do case

Extrair as seguintes informações de um produto:

- Título
- Preço
- Imagem
- Descrição

---

## Tecnologias utilizadas

- Java
- Selenium WebDriver
- Maven
- Jackson (conversão para JSON)

---

## Estrutura do projeto

O projeto segue uma organização simples baseada em separação de responsabilidades:

```
src/main/java/org/example
    model
        Product.java
    scraper
        Scraper.java
    util
        JsonUtil.java
    Main.java
```

Descrição das camadas:

- model: representa os dados do produto
- scraper: lógica de extração com Selenium
- util: conversão para JSON
- Main: ponto de entrada da aplicação

---

## Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/luizmendessf/WebScraper.git
```

### 2. Abrir o projeto

Importe o projeto em uma IDE como IntelliJ ou Eclipse.

### 3. Executar o projeto

Execute a classe:

```
Main.java
```

---

## Uso do sistema

Ao executar o programa, será exibido um menu interativo:

```
1 - Inserir link
2 - Usar link padrão
3 - Sair
```

### Opções:

**1 - Inserir link**  
Permite ao usuário informar manualmente um link de produto da Netshoes.

O sistema realiza validações básicas:
- Verifica se a URL pertence à Netshoes
- Verifica se o link parece ser de um produto

Caso o link seja inválido, uma mensagem de erro será exibida.

---

**2 - Usar link padrão**  
Executa o scraper utilizando um link fixo previamente definido no código.

---

**3 - Sair**  
Encerra a execução do programa.

---

## Exemplo de saída

```json
{
  "titulo": "Camisa Brasil Nike I 2026/27 Torcedor Pro Masculina - Amarelo+Verde",
  "preco": "R$ 449,99",
  "imagem": "https://static.netshoes.com.br/...",
  "descricao": "A Nike apresenta: O uniforme principal do Brasil 2026..."
}
```

---

## Desafios encontrados

Durante o desenvolvimento, alguns pontos exigiram atenção:

- O site utiliza renderização dinâmica, exigindo uso de WebDriverWait
- Pequenas diferenças em seletores CSS impactam diretamente na extração
- Nem todos os elementos estão disponíveis imediatamente no DOM
- Validação de links para evitar falhas na execução

---

## Possíveis melhorias

- Suporte a múltiplas páginas
- Interface gráfica simples
- Testes automatizados
- API para expor os dados coletados



---

Desenvolvido por Luiz Mendes.