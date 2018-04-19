package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Suporte.Generetor;
import Suporte.Screenshot;

public class LoginSite {

	static WebDriver navegador;

	public LoginSite(WebDriver navegador) {
		this.navegador = navegador;
	}

	public LoginSite varLogin(String login) {
		navegador.findElement(By.name("username")).sendKeys(login);
		return this;

	}
	
	public LoginSite varPassword(String pass){
		navegador.findElement(By.name("password")).sendKeys(pass);
		return this;
	}
	
	public LoginSite varSeguraca(){
		navegador.findElement(By.name("secure_session")).click();
		return this;
	}

	public PageUser clicarLogar() {
		new Screenshot().TirarPrint();
		navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[6]/td/input")).click();
		return new PageUser(navegador);
	}
	
	public void deslogar() {
		navegador.findElement(By.linkText("Logout")).click();
	}

}
