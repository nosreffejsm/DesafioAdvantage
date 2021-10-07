package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CategoryPage {

	private WebDriver driver;
	
	private By categoriaTitulo = By.className("categoryTitle");
	//private By nomeProduto = By.cssSelector("ul>.ng-scope:nth-child(1)>P>a.productName");
	//private By precoProduto = By.cssSelector("ul>.ng-scope:nth-child(1)>P>a.productPrice");
	private By listaNomesProdutos = By.cssSelector("div ul>.ng-scope >p>a.productName");
	private By listaPrecosProdutos = By.cssSelector("div ul>.ng-scope >p>a.productPrice");
	

	public CategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public String obterNomeCategoria() {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(categoriaTitulo));

		return driver.findElement(categoriaTitulo).getText();
	}


	public String obterNomeProduto(int i) {

		return driver.findElements(listaNomesProdutos).get(i).getText();
		
	}

	public ProductPage clicarProduto(int i) {
		
		driver.findElements(listaNomesProdutos).get(i).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new ProductPage(driver);
	}

	public String obterPrecoProduto(int i) {
		return driver.findElements(listaPrecosProdutos).get(i).getText();
	}
	
}
