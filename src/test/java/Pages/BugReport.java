package Pages;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Suporte.Screenshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastrarUmBugNoSite.csv")
public class BugReport {

	static WebDriver navegador;

	public BugReport(WebDriver navegador) {
		this.navegador = navegador;
	}

	public BugReport typeReporte(
			// String tipo1, String tipo2, String tipo3, String tipo4, String
			// tipo5,
			// String tipo6, String tipo7, String tipo8, String tipo9,
			// String tipo10, String tipo11, String tipo12,String tipo13

			@Param(name = "category_id") String tipo1, @Param(name = "reproducibility") String tipo2,
			@Param(name = "severity") String tipo3, @Param(name = "priority") String tipo4,
			@Param(name = "profile_id") String tipo5, @Param(name = "platform") String tipo6,
			@Param(name = "os") String tipo7, @Param(name = "os_build") String tipo8,
			@Param(name = "handler_id") String tipo9, @Param(name = "summary") String tipo10,
			@Param(name = "description") String tipo11, @Param(name = "steps_to_reproduce") String tipo12,
			@Param(name = "additional_info") String tipo13
			) {

		// Selecionar a categoria "[All Projects] General" o item que tenha o
		// name "category_id"
		WebElement select1 = navegador.findElement(By.name("category_id"));
		new Select(select1).selectByVisibleText(tipo1);


		WebElement select2 = navegador.findElement(By.name("reproducibility"));
		new Select(select2).selectByVisibleText(tipo2);

		WebElement select3 = navegador.findElement(By.name("severity"));
		new Select(select3).selectByVisibleText(tipo3);

		WebElement select4 = navegador.findElement(By.name("priority"));
		new Select(select4).selectByVisibleText(tipo4);

		WebElement select5 = navegador.findElement(By.name("profile_id"));
		new Select(select5).selectByVisibleText(tipo5);

		navegador.findElement(By.name("platform")).sendKeys(tipo6);
		navegador.findElement(By.id("os")).sendKeys(tipo7);
		navegador.findElement(By.id("os_build")).sendKeys(tipo7);

		WebElement handler_id = navegador.findElement(By.name("handler_id"));
		new Select(handler_id).selectByVisibleText(tipo8);

		navegador.findElement(By.name("summary")).sendKeys(tipo9);
		navegador.findElement(By.name("description")).sendKeys(tipo10);
		navegador.findElement(By.name("steps_to_reproduce")).sendKeys(tipo11);
		navegador.findElement(By.name("additional_info")).sendKeys(tipo12);

		String caminho = "C:/Users/Melquiades/Pictures/icon/icon.PNG";
		// ,"./extras/icon.PNG"
		// /Project_Report_Mantis/extras/icon.PNG
		// C:/Users/Melquiades/Pictures/icon/icon.PNG
		try {
			// WebElement carregarimg =
			// navegador.findElement(By.id("ufile[]")).sendKeys(new
			// CarregarIMG().CarregarIMG());
			// navegador.manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
			// carregarimg.sendKeys(new CarregarIMG().CarregarIMG());

			// URL resource = getClass().getResource(caminho);
			// File file = new File(resource.toURI());
			// setando o img
			// ImageIcon imgTratada = new ImageIcon(file.getAbsoluteFile());

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

		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new Screenshot().TirarPrint();
		return this;
	}

	public PageViewIssues submeterBug() {

		return new PageViewIssues();
	}

}
