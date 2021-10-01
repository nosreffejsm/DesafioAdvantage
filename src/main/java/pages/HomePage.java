package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	List<WebElement> listaCategorias = new ArrayList();

	private By textoProdutosNoCarrinho = By.cssSelector("span.cart.ng-binding.ng-hide");

	private By categorias = By.className("categoryCell");

	private By nomeCategoria = By.cssSelector(".categoryCell span");

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	public int contarCategorias() {
		carregarListaCategorias();
		return listaCategorias.size();
	}

	private void carregarListaCategorias() {
		listaCategorias = driver.findElements(categorias);

	}

	public int obterQuantidadeProdutosNoCarrinho() {

		String textQuantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho)
				.getAttribute("textContent");
		int intQuantidadeProdutosNoCarrinho = Integer.parseInt(textQuantidadeProdutosNoCarrinho);
		return intQuantidadeProdutosNoCarrinho;
	}

	public String obterNomeCategoria(int indice) {
		return driver.findElements(nomeCategoria).get(indice).getText();
	}

	public CategoryPage clicarCategoria(int indice) {
		driver.findElements(nomeCategoria).get(indice).click();
		return new CategoryPage(driver);
	}

}
