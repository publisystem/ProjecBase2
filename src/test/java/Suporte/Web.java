package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Web {
	
	static String URL = "http://mantis-prova.base2.com.br/";
	static WebDriver navegador;
	
	public static WebDriver createMarionete() {
		// Caminho de acesso as Mariometes para teste
		
		System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:/selenium/geckodriver.exe");
//		System.setProperty("webdriver.opera.driver", "C:/selenium/opera/operadriver.exe");
//		System.setProperty("webdriver.edge.driver", "C:/selenium/MicrosoftWebDriver.exe");
//		System.setProperty("webdriver.ie.driver", "C:/selenium/MicrosoftWebDriver.exe");
		
 
		// Instancia do navegador a ser usado
		navegador = new ChromeDriver();
//		navegador = new InternetExplorerDriver();
//		navegador = new FirefoxDriver();
//		navegador = new OperaDriver();
		
		// Maximiza a tela
		navegador.manage().window().maximize();
		// Acessa o link da pagina
		navegador.get(URL);
		
		return navegador;
	}

}
