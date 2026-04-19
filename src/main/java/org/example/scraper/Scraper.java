package org.example.scraper;

import org.example.model.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class Scraper {

    public Product extrairProduto(String url) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get(url);

            // Título
            By tituloSelector = By.cssSelector("h1.product-name");

            WebElement tituloElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(tituloSelector)
            );

            String titulo = tituloElement.getText();


            // Preço
            By precoSelector = By.cssSelector(".saleInCents-value");

            WebElement precoElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(precoSelector)
            );

            String preco = precoElement.getText();


            // Imagem
            String imagem = "";

            By imagensSelector = By.cssSelector(".productImages img");

            List<WebElement> imagens = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(imagensSelector)
            );

            for (WebElement img : imagens) {

                String src = img.getAttribute("src");

                if (src == null || src.isEmpty()) {
                    src = img.getAttribute("data-src");
                }

                if (src != null && src.contains("netshoes") && src.contains(".jpg")) {
                    imagem = src;
                    break;
                }
            }

            if (imagem.isEmpty()) {
                WebElement img = wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.cssSelector("img"))
                );

                imagem = img.getAttribute("src");
            }


            // Descriçãp
            By descricaoSelector = By.cssSelector(".features--description");

            WebElement descricaoElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(descricaoSelector)
            );

            String descricao = descricaoElement.getText();

            // Return
            return new Product(titulo, preco, imagem, descricao);

        } finally {
            driver.quit();
        }
    }
}