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
		//navegador.findElement(By.linkText("My Account")).click();
		new Screenshot().TirarPrint();
		return navegador.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[1]/span[1]")).getText();
	}

	public BugReport clicarnoReport() throws Exception{
//		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		WebDriverWait stopmin = new WebDriverWait(navegador, 8);
		stopmin.until(ExpectedConditions.visibilityOf((WebElement) By.linkText("Report Issue")));
//		stopmin.until(ExpectedConditions.elementToBeClickable(By.linkText("Report Issue")));
		
//		try {
//			
//			WebElement textlink = navegador.findElement(By.linkText("Report Issue"));
//			if (textlink.isEnabled())
//			   System.out.println("View link: Ativo");
//			else
//			   System.out.println("View link: Desativado");
	
			navegador.findElement(By.linkText("Report Issue")).click();
//		} catch (Exception e) {
//			System.out.println("Não encontrou a link a ser clicado!");
//		}
		
		
		return new BugReport(navegador);
	}

}
