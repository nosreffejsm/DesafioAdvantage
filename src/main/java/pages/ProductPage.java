package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;

	}
	
	private By nomeProduto = By.cssSelector("#Description>h1.roboto-regular");
	private By precoProduto = By.cssSelector("#Description>h2.roboto-thin");

	public String obterNomeProduto() {
		
		return driver.findElement(nomeProduto).getText();
	}

	public String obterPrecoProduto() {
		
		return driver.findElement(precoProduto).getText();
	}
	
	

}
