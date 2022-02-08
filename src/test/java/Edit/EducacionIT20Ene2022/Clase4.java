package Edit.EducacionIT20Ene2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Clase4 {
	String driverPath = "..\\EducacionIT20Ene2022\\Drivers\\chromedriver.exe";
	String url = "https://www.saucedemo.com/";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP01 - Login Caso Positivo", priority=100)
	public void login() {
		// 1. Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		// Validar que avance al catalogo de productos
		String urlEsperada = "https://www.saucedemo.com/inventory.html";
		String urlActual = driver.getCurrentUrl();
		Assert.assertEquals(urlActual, urlEsperada);
	}
	
	@Test(description="CP02 - Crear Orden Caso Positivo", priority=2000)
	public void createOrder() {
		// 2. Selección del Producto
		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
		
		// 3 . Clic en Checkout
		driver.findElement(By.name("checkout")).click();	
		
		// 4. Información Personal
		driver.findElement(By.id("first-name")).sendKeys("Rafael");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Lopez");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("90210");
		driver.findElement(By.name("continue")).click();
		
		// 5. Finish
		driver.findElement(By.cssSelector("#finish")).click();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
