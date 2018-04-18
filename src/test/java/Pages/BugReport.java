package Pages;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Suporte.Screenshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastrarUmBugNoSite_e.csv")
public class BugReport {

	static WebDriver navegador;

	public BugReport(WebDriver navegador) {
		this.navegador = navegador;
	}

	public BugReport typeReporte(
			String selec1, String selec2, String selec3, String selec4, String selec5,
			String info1, String info2, String info3, String selec6, 
			String caixa1, String caixa2, String caixa3,String caixa4) {
		//, String caminho
		System.out.print("Item do arquivo CSV: "+selec1);
		System.out.print("Item do arquivo CSV: "+selec2);
		System.out.print("Item do arquivo CSV: "+selec3);
		// Selecionar a categoria "[All Projects] General" o item que tenha o
		// name "category_id"
		WebElement select1 = navegador.findElement(By.name("category_id"));
		new Select(select1).selectByVisibleText(selec1);

		WebElement select2 = navegador.findElement(By.name("reproducibility"));
		new Select(select2).selectByVisibleText(selec2);

		WebElement select3 = navegador.findElement(By.name("severity"));
		new Select(select3).selectByVisibleText(selec3);

		WebElement select4 = navegador.findElement(By.name("priority"));
		new Select(select4).selectByVisibleText(selec4);

		WebElement select5 = navegador.findElement(By.name("profile_id"));
		new Select(select5).selectByVisibleText(selec5);

		navegador.findElement(By.name("platform")).sendKeys(info1);
		navegador.findElement(By.id("os")).sendKeys(info2);
		navegador.findElement(By.id("os_build")).sendKeys(info3);

		WebElement handler_id = navegador.findElement(By.name("handler_id"));
		new Select(handler_id).selectByVisibleText(selec6);

		navegador.findElement(By.name("summary")).sendKeys(caixa1);
		navegador.findElement(By.name("description")).sendKeys(caixa2);
		navegador.findElement(By.name("steps_to_reproduce")).sendKeys(caixa3);
		navegador.findElement(By.name("additional_info")).sendKeys(caixa4);


		String caminho = "C:/Users/Melquiades/Pictures/icon/icon.PNG";
		//,"./extras/icon.PNG"
		// /Project_Report_Mantis/extras/icon.PNG
		//C:/Users/Melquiades/Pictures/icon/icon.PNG
		try {
			//WebElement carregarimg = 
			//navegador.findElement(By.id("ufile[]")).sendKeys(new CarregarIMG().CarregarIMG());
			//navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//carregarimg.sendKeys(new CarregarIMG().CarregarIMG());
			
			//URL resource = getClass().getResource(caminho);
			//File file = new File(resource.toURI());
			// setando o img
			//ImageIcon imgTratada = new ImageIcon(file.getAbsoluteFile());
			
			navegador.findElement(By.id("ufile[]")).sendKeys(caminho);
		} catch (Exception e) {
			System.out.println("Imagem de evidência não carregou! "+e.getMessage());
		}

		
		WebElement radioBtn2 = navegador.findElement(By.name("view_state"));
		radioBtn2.click();
		
		WebElement ckeckBtn2 = navegador.findElement(By.id("report_stay"));
		ckeckBtn2.click();

		WebElement Btn3 = navegador.findElement(By.xpath("/html/body/div[3]/form/table/tbody/tr[16]/td[2]/input"));
		Btn3.click();
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Screenshot().TirarPrint();
		return this;
	}

	// public PageViewIssues submeterBug(){

	// return new PageViewIssues();
	// }

}
