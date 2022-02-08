package pruebas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import Utilidades.DatosExcel;
import paginas.LoginPage;

public class CreateOrder_DataProviderTest {
	WebDriver driver;
	String driverPath = "..\\EducacionIT20Ene2022\\Drivers\\chromedriver.exe";
	String url = "https://www.saucedemo.com/";
	String nombreDocumento = "..\\EducacionIT20Ene2022\\Evidencias\\evidenciaPrueba.docx";
	String nombreImagen = "..\\EducacionIT20Ene2022\\Evidencias\\img01.png";
	
	@BeforeSuite
	public void setUp() throws Exception, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		CapturaEvidencia.escribirTituloEnDocumento(nombreDocumento, "Documento de Evidencias - Curso Automatización", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, nombreImagen, nombreDocumento, "Pantalla Principal");
	}
	
	@Test(dataProvider="Datos Login")
	public void createOrder(String username, String password) throws InvalidFormatException, IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.fillCredentials(username, password);
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, nombreImagen, nombreDocumento, "Caso de Prueba Login - Usuario: " + username + ", Contraseña: " + password);
		
		login.clicOnLogin();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, nombreImagen, nombreDocumento, "Resultado Obtenido");
		
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
		
		driver.navigate().back();
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT20Ene2022\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
}
