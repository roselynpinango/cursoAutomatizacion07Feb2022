package Edit.EducacionIT20Ene2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Clase3 {
	String driverPath = "..\\EducacionIT20Ene2022\\Drivers\\chromedriver.exe";
	String url = "https://www.saucedemo.com/";
	
	@Test
	public void createOrder() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// 1. Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
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
		
		// driver.close();
	}
}
