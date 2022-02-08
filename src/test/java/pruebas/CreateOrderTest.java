package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.AvanceCompra;
import paginas.ConfirmacionCompra;
import paginas.DatosPersonales;
import paginas.InventoryPage;
import paginas.LoginPage;

public class CreateOrderTest {
	WebDriver driver;
	String driverPath = "..\\EducacionIT20Ene2022\\Drivers\\chromedriver.exe";
	String url = "https://www.saucedemo.com/";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void createOrder() {
		LoginPage login = new LoginPage(driver);
		login.fillCredentials("standard_user", "secret_sauce");
		login.clicOnLogin();
		
		InventoryPage inventory = new InventoryPage(driver);
		inventory.addToCart();
		inventory.clicOnCart();
		
		AvanceCompra avance = new AvanceCompra(driver);
		avance.clicEnCheckout();
		
		DatosPersonales datos = new DatosPersonales(driver);
		datos.ingresarFirstname("Lorena");
		datos.ingresarLastname("Pereira");
		datos.ingresarZipcode("94567");
		datos.clicEnContinue();
		
		ConfirmacionCompra confirmacion = new ConfirmacionCompra(driver);
		confirmacion.clicEnFinish();
		
		// Comprobacion de orden pre-generada
		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
