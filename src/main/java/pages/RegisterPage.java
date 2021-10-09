package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;

	}

	private By input_UserName 			=	By.name("usernameRegisterPage");
	private By input_Email 				=	By.name("emailRegisterPage");
	private By input_Password 			=	By.name("passwordRegisterPage");
	private By input_CPassword 			=	By.name("confirm_passwordRegisterPage");
	private By input_FirstName 			=	By.name("first_nameRegisterPage");
	private By input_LastName 			=	By.name("last_nameRegisterPage");
	private By input_PhoneNumber 		=	By.name("phone_numberRegisterPage");
	private By listbox_country			=	By.name("countryListboxRegisterPage");
	private By input_City 				= 	By.name("cityRegisterPage");
	private By input_Address 			=	By.name("addressRegisterPage");
	private By input_State 				=	By.name("state_/_province_/_regionRegisterPage");
	private By input_PostalCode 		=	By.name("postal_codeRegisterPage");
	private By checkbox_IAgree 			=	By.name("i_agree");
	private By register		 			=	By.id("register_btnundefined");

	public void preencherFormularioCadastro(String usuarioLogin, String senhaLogin) {

		driver.findElement(input_UserName).sendKeys(usuarioLogin);
		driver.findElement(input_Email).sendKeys("jeff@teste.com");
		driver.findElement(input_Password).sendKeys(senhaLogin);
		driver.findElement(input_CPassword).sendKeys(senhaLogin);
		driver.findElement(input_FirstName).sendKeys("Teste");
		driver.findElement(input_LastName).sendKeys("Silva");
		driver.findElement(input_PhoneNumber).sendKeys("11999999999");
		new Select(driver.findElement(listbox_country)).selectByVisibleText("Brazil");
		driver.findElement(input_City).sendKeys("São Paulo");
		driver.findElement(input_Address).sendKeys("Rua UmDoisTres");
		driver.findElement(input_State).sendKeys("São Paulo");
		driver.findElement(input_PostalCode).sendKeys("0123000");
		driver.findElement(checkbox_IAgree).click();

	}

	public HomePage clicarRegister() {
		driver.findElement(register).click();
		return new HomePage(driver);
	}

}
