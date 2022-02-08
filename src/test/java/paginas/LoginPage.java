package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="user-name")
	WebElement txtUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(css="#login-button")
	WebElement btnLogin;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // Inicializa los elementos de la página
	}
	
	public void fillCredentials(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
	}
	
	public void clicOnLogin() {
		btnLogin.click();
	}
}
