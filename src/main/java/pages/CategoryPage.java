package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

	private WebDriver driver;
	
	private By categoriaTitulo = By.className("categoryTitle");

	public CategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	public String obterNomeCategoria() {
		return driver.findElement(categoriaTitulo).getText();
	}
	
}
