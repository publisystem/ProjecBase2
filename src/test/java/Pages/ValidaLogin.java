package Pages;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Suporte.Generetor;
import Suporte.Screenshot;

public class ValidaLogin {

	static WebDriver navegador;
	//static BugReport nextaction;

	public ValidaLogin(WebDriver navegador) {
		this.navegador = navegador;
	}

	public void paginalogin() {

		// Digitar no campo que tenha o na tag "name" como "username" o usuario
		// "william.melquiades"
		WebElement usuariodeacesso = navegador.findElement(By.name("username"));
		usuariodeacesso.sendKeys("william.melquiades");

		// No campo name com "password" digitar a senha @01!01@
		WebElement senhadeacesso = navegador.findElement(By.name("password"));
		senhadeacesso.sendKeys("@01!01@");
		// Desmarcar o campo que tenha o name igual a "secure_session" para que
		// a seção possa ser acessada de qualquer IP
		WebElement checagemdeseguranca = navegador.findElement(By.name("secure_session"));
		checagemdeseguranca.click();
		// Tirar print de evindencia de tela
		// TirarPrint(); Descomentar

		// Clicar no botão com value igual a "Login"

		WebElement btlogar = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input"));
		btlogar.click();

		// Validar se o usuario logado corresponde ao usuario usado no login
		validaUsuario();
		//proximapagina();
		// TirarPrint(); Descomentar

		// Acessar os projetos do usuario logado
		// Selecionar no campo que tenha o name como "project_id" os projetos do
		// usuario "William Melquíades's Project"

		// Clicar no botão de value "Switch"

		// Proximo teste: Salvar um Filtro corrente
		// clicar no menu superior com o nome Report Issue que tem um link
		// href="/bug_report_page.php"

	}

	public String validaUsuario() {
		return navegador.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[1]/span[1]")).getText();
	}

	public void TirarPrint() {
		String screenshotArquivo = "C:/EvidenciaSelenium/" + Generetor.dataHoraParaArquivo() + ".png";
		Screenshot.TirarEvidencia(navegador, screenshotArquivo);
	}

	
	
//	public void proximapagina(){
//		nextaction = new BugReport(navegador);
//	}


}
