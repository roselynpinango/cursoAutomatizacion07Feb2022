package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ConfirmacionCompra {
	@FindBy(id="finish")
	WebElement btnFinish;
	
	public ConfirmacionCompra(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this); // Inicializar los elementos de la clase
	}
	
	public void clicEnFinish() {
		btnFinish.click();
	}
}
