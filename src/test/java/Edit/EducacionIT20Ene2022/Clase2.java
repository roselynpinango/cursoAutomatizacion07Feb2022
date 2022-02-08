package Edit.EducacionIT20Ene2022; // a qué paquete pertenece la clase

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Clase Principal
public class Clase2 {
	// Método Login en Chrome - Web OrangeHRM
	@Test
	public void loginChromeOrangeHRM() {
		// 1. Indicar dónde está el driver de Chrome
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIT20Ene2022\\Drivers\\chromedriver.exe");
		
		// 2. Abrir la página que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("Título: " + driver.getTitle());
		
		// 3. Ingresar las credenciales (username y password)
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		System.out.println("TxtUsername Habilitado?: " + txtUsername.isEnabled());
		
		txtUsername.sendKeys("Admin");
		
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		txtPassword.sendKeys("admin123");
		
		// Simulamos presionar la tecla Enter
		txtPassword.sendKeys(Keys.ENTER);
		
		// Simulamos presionar CTRL + V
		//txtPassword.sendKeys(Keys.chord(Keys.CONTROL, "V"));
		
		// 4. Hacer clic en el botón LOGIN
		//WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		//btnLogin.click();		
		
		//driver.close(); // cierra la ventana actual
	}
	
	// Método Login en Firefox - Web OrangeHRM
	@Test
	public void loginFirefoxOrangeHRM() {
		// 1. Indicar dónde está el driver de Chrome
		System.setProperty("webdriver.gecko.driver", "..\\EducacionIT20Ene2022\\Drivers\\geckodriver.exe");
		
		// 2. Abrir la página que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		// 3. Ingresar las credenciales (username y password)
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		txtUsername.sendKeys("Admin");
		
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		txtPassword.sendKeys("admin123");
		
		// 4. Hacer clic en el botón LOGIN
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
		
		driver.close(); // cierra la ventana actual
	}
}
