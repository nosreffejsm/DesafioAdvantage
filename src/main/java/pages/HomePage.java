package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	
	List<WebElement> listaCategorias = new ArrayList();
	
	private By textoProdutosNoCarrinho = By.cssSelector("span.cart.ng-binding.ng-hide");
	
	private By categorias = By.className("categoryCell");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}

	public int contarProdutos() {
		carregarListaCategorias();
		return listaCategorias.size();
	}
	
	private void carregarListaCategorias() {
		listaCategorias = driver.findElements(categorias);
		
	}

	public int obterQuantidadeProdutosNoCarrinho() {
	
		String textQuantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho).getAttribute("textContent");
		int intQuantidadeProdutosNoCarrinho = Integer.parseInt(textQuantidadeProdutosNoCarrinho);
		return intQuantidadeProdutosNoCarrinho;
	}
	
	

}
