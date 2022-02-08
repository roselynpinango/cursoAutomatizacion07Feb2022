package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DatosPersonales {
	@FindBy(xpath="//input[@id='first-name']")
	WebElement txtFirstName;
			
	@FindBy(css="#last-name")
	WebElement txtLastName;
		
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement txtZipcode;
	
	@FindBy(css="#continue")
	WebElement btnContinue;
	
	public DatosPersonales(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this); // Inicializar los elementos de la clase
	}
	
	public void ingresarFirstname(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void ingresarLastname(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void ingresarZipcode(String zipCode) {
		txtZipcode.sendKeys(zipCode);
	}
	
	public void clicEnContinue() {
		btnContinue.click();
	}
}
