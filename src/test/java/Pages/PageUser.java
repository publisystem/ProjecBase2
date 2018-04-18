package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Suporte.Screenshot;

public class PageUser {

	static WebDriver navegador;

	public PageUser(WebDriver navegador) {
		this.navegador = navegador;
	}

	public String validaUsuario() {
		navegador.findElement(By.linkText("My Account")).click();
		new Screenshot().TirarPrint();
		return navegador.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[1]/span[1]")).getText();
	}
	

	public BugReport clicarnoReport() throws Exception{
		
		WebDriverWait stopmin = new WebDriverWait(navegador, 10);
		stopmin.until(ExpectedConditions.elementToBeClickable(By.linkText("Report Issue")));
		
		navegador.findElement(By.linkText("Report Issue")).click();
		
		return new BugReport(navegador);
	}

}
