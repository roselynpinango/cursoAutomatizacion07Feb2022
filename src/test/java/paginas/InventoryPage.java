package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")
	WebElement lnkCart;
	
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart() {
		btnAddToCart.click();
	}
	
	public void clicOnCart() {
		lnkCart.click();
	}
	
}
