package Tests;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BugReport;
import Pages.ValidaLogin;
import Suporte.Web;

public class ReportMantis {

	static String URL = "http://mantis-prova.base2.com.br/";
	static WebDriver navegador;
	static ValidaLogin actionpages;
	static BugReport actionbugs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		navegador = Web.createMarionete();

//		// Caminho de acesso as Mariometes para teste
//		 System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");
//		//System.setProperty("webdriver.gecko.driver", "C:/selenium/geckodriver.exe");
//
//		
//		// Instancia do navegador a ser usado
//		navegador = new ChromeDriver();
//		//navegador = new FirefoxDriver();
//		//navegador.get(URL);
//		// Maximiza a tela
//		navegador.manage().window().maximize();
//		// Acessa o link da pagina
//		navegador.get(URL);
		
		// Instancia da classe Pages para passagem do acesso do navegador
		//actionpages = new ValidaLogin(navegador);
		//actionbugs  = new BugReport(navegador);
		
	}

	@After
	public void tearDown() throws Exception {
		 //navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 //navegador.close();
	}

	@Test
	public void validarUsuarioLogado() {
		//Chamada pagina para realizar login
		//actionpages.paginalogin();	
		//assertEquals( actionpages.validaUsuario(), "william.melquiades" );	
		//actionpages.deslogar();
	}
	
	@Test
	public void criarrepotbug() throws AWTException{
		
		//actionbugs.reportarbugs();
		//assertEquals( actionpages.validaarquivo(), "Operation successful." );
	}
	
}
