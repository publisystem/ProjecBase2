package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Suporte.Screenshot;

public class BugReport {

	static WebDriver navegador;

	public BugReport(WebDriver navegador) {
		this.navegador = navegador;
	}

	public BugReport varTipo1(String tipo1){
		WebElement var1 = navegador.findElement(By.name("category_id"));
		new Select(var1).selectByVisibleText(tipo1);
		return this;
	}
	
	public BugReport varTipo2(String tipo2) {
		WebElement var2 = navegador.findElement(By.name("reproducibility"));
		new Select(var2).selectByVisibleText(tipo2);
		return this;
	}
	public BugReport varTipo3(String tipo3) {
		WebElement var3 = navegador.findElement(By.name("severity"));
		new Select(var3).selectByVisibleText(tipo3);
		return this;
	}
	public BugReport varTipo4(String tipo4) {
		WebElement var4 = navegador.findElement(By.name("priority"));
		new Select(var4).selectByVisibleText(tipo4);
		return this;
	}
	public BugReport varTipo5(String tipo5) {
		WebElement var = navegador.findElement(By.name("profile_id"));
		new Select(var).selectByVisibleText(tipo5);
		return this;
	}
	public BugReport varTipo6(String tipo6) {
		navegador.findElement(By.name("platform")).sendKeys(tipo6);

		return this;
	}
	public BugReport varTipo7(String tipo7) {
		navegador.findElement(By.id("os")).sendKeys(tipo7);
		return this;
	}
	public BugReport varTipo8(String tipo8) {
		navegador.findElement(By.id("os_build")).sendKeys(tipo8);
		return this;
	}
	public BugReport varTipo9(String tipo9) {
		WebElement var = navegador.findElement(By.name("handler_id"));
		new Select(var).selectByVisibleText(tipo9);
		return this;
	}
	public BugReport varTipo10(String tipo10) {
		navegador.findElement(By.name("summary")).sendKeys(tipo10);
		return this;
	}
	public BugReport varTipo11(String tipo11) {
		navegador.findElement(By.name("description")).sendKeys(tipo11);
		return this;
	}
	public BugReport varTipo12(String tipo12) {
		navegador.findElement(By.name("steps_to_reproduce")).sendKeys(tipo12);
		return this;
	}
	public BugReport varTipo13(String tipo13) {
		navegador.findElement(By.name("additional_info")).sendKeys(tipo13);
		return this;
	}
	
	public BugReport acoesInternasReport(){
		
		String caminho = "C:/Users/Melquiades/Pictures/icon/icon.PNG";
//		String caminho = "/Project_Report_Mantis/extras/icon.PNG";

		try {
			navegador.findElement(By.id("ufile[]")).sendKeys(caminho);
		} catch (Exception e) {
			System.out.println("Imagem de evidência não carregou! " + e.getMessage());
		}
		
		WebElement radioBtn2 = navegador.findElement(By.name("view_state"));
		radioBtn2.click();

		WebElement ckeckBtn2 = navegador.findElement(By.id("report_stay"));
		ckeckBtn2.click();
		
		WebElement Btn3 = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[16]/td[2]/input"));
		Btn3.click();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Screenshot().TirarPrint();	
	
		return this;
	}

	public PageViewIssues submeterBug() {
		
		WebDriverWait stopmin = new WebDriverWait(navegador, 10);
		stopmin.until(ExpectedConditions.elementToBeClickable(By.linkText("View Issues")));
		try {
			navegador.findElement(By.id("View Issues")).click();
		} catch (Exception e) {
			
		}finally {
			navegador.findElement(By.linkText("Report Issue")).click();
		}
		
		return new PageViewIssues(navegador);
		
	}

}
