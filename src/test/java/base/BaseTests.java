package base;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseTests {

	private static WebDriver driver;
	protected HomePage homePage;
	
	@BeforeAll
	public static void inicializar() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	
	@BeforeEach
	public void carregarPaginaInicial() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
		homePage = new HomePage(driver);
	}
	
	@AfterAll
	public static void finalizar() {
		driver.quit();
	}
	
	public static void voltarPaginaAnterior() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.navigate().back();
	}
}
