package id.ac.ui.cs.advprog.eshop.functional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
  @LocalServerPort private int serverPort;

  @Value("${app.baseUrl:http://localhost}")
  private String testBaseUrl;

  private String baseUrl;

  @BeforeEach
  void setupTest() {
    baseUrl = String.format("%s:%d/product/list", testBaseUrl, serverPort);
  }

  @Test
  void testNewLine(ChromeDriver driver) throws Exception {
    driver.get(baseUrl);

    boolean lineDoesNotExistAtFirst;
    try {
      String tdContents = driver.findElement(By.tagName("td")).getText();
      lineDoesNotExistAtFirst = false;
    } catch (NoSuchElementException e) {
      lineDoesNotExistAtFirst = true;
    }

    assertTrue(lineDoesNotExistAtFirst);

    WebElement addProductButton = driver.findElement(By.id("addProductBtn"));
    addProductButton.click();

    WebElement inputName = driver.findElement(By.id("nameInput"));
    String name = "Book";
    inputName.sendKeys(name);

    WebElement inputQuantity = driver.findElement(By.id("quantityInput"));
    String quantity = "10";
    inputQuantity.sendKeys(quantity);

    WebElement submitButton = driver.findElement(By.id("submitBtn"));
    submitButton.click();

    boolean newLineFound;
    try {
      String tdContents = driver.findElement(By.tagName("td")).getText();
      newLineFound = true;
    } catch (NoSuchElementException e) {
      newLineFound = false;
    }

    assertTrue(newLineFound);
  }
}
