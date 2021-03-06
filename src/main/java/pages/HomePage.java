package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {

	private static WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}
	
	List<WebElement> listaCategorias = new ArrayList();

	private By textoProdutosNoCarrinho = By.cssSelector("span.cart.ng-binding.ng-hide");
	private By categorias = By.className("categoryCell");
	private By nomeCategoria = By.cssSelector(".categoryCell span");
	private By menuUser = By.id("menuUserLink");

	private static By loader = By.className("loader");
	private static By usuarioLogado = By.className("containMiniTitle");

	
	public int contarCategorias() {
		carregarListaCategorias();
		return listaCategorias.size();
	}

	private void carregarListaCategorias() {
		listaCategorias = driver.findElements(categorias);

	}
	
	public static void fluentWaitVisibilityOfElementLocated(By element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

	public int obterQuantidadeProdutosNoCarrinho() {

		String textQuantidadeProdutosNoCarrinho = driver.findElement(textoProdutosNoCarrinho)
				.getAttribute("textContent");
		int intQuantidadeProdutosNoCarrinho = Integer.parseInt(textQuantidadeProdutosNoCarrinho);
		return intQuantidadeProdutosNoCarrinho;
	}

	public String obterNomeCategoria(int indice) {
		
		fluentWaitVisibilityOfElementLocated(nomeCategoria);

		return driver.findElements(nomeCategoria).get(indice).getText();
	}

	public CategoryPage clicarCategoria(int indice) {
		
		fluentWaitVisibilityOfElementLocated(nomeCategoria);
		
		driver.findElements(nomeCategoria).get(indice).click();
		return new CategoryPage(driver);
	}

	public LoginModalPage clicarLoginUser() {
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		
		driver.findElement(menuUser).click();
		return new LoginModalPage(driver);
		
	}


	public static String obterUsuarioLogado() {

		//fluentWaitVisibilityOfElementLocated(usuarioLogado);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return driver.findElement(usuarioLogado).getText();
		
	}

}
