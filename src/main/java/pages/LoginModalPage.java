package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class LoginModalPage {
	
	private WebDriver driver;

	public LoginModalPage(WebDriver driver) {
		this.driver = driver;

	}
	
	private By loader = By.className("loader");
	private By botao_createNewCccount = By.className("create-new-account");
	private By input_UserName =	By.name("username");
	private By input_Password =	By.name("password");
	private By botao_SignIn = By.id("sign_in_btnundefined");
	private By mensagem_SignIn = By.id("signInResultMessage");
	private By botao_deleteMain = By.className("deleteBtnText");
	private By botao_Yes = By.className("deleteRed");	
	
	public void fluentWaitVisibilityOfElementLocated(By element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}
	
	public String efetuarLogin (String usuarioLogin, String senhaLogin) {
		driver.findElement(input_UserName).sendKeys(usuarioLogin);
		driver.findElement(input_Password).sendKeys(senhaLogin);
		driver.findElement(botao_SignIn).click();
		
		if (HomePage.obterUsuarioLogado().equals(usuarioLogin))
			return "LogadoComSucesso";
		else
			return "LoginIcorreto";
		
	}
	
	public RegisterPage clicarCreateNewAccount() {
		
		fluentWaitVisibilityOfElementLocated(botao_createNewCccount);
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		
		driver.findElement(botao_createNewCccount).click();
		return new RegisterPage(driver);
	}
	

	
	public String checarUsuariioExiste_DeletarUsuario(String usuarioLogin, String senhaLogin) {
		
		String resultadoLogin = efetuarLogin(usuarioLogin, senhaLogin);
		
		if (resultadoLogin.equals("LoginIcorreto")) {
			driver.get("http://advantageonlineshopping.com/");
			return "OK";
			}
		else {

			driver.get("http://advantageonlineshopping.com/#/myAccount");
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
			
			fluentWaitVisibilityOfElementLocated(botao_deleteMain);
			driver.findElement(botao_deleteMain).click();
			driver.findElement(botao_Yes).click();		
			driver.get("http://advantageonlineshopping.com/");
			return "Deletado";
		}
		
	}

}
