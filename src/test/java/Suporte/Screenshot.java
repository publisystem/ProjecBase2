package Suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Screenshot extends Web{
 
	public static void TirarEvidencia(WebDriver navegador, String arquivo){
	 
	 java.io.File screen = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
	 
	 try {
		 
		 FileUtils.copyFile(screen, new java.io.File(arquivo));
		
	} catch (Exception e) {
		System.out.println("Deu ruim na foto: " +e.getMessage());
	}
	 
	 System.out.println(" Item Navegador: " +navegador + "\n"+
			            " Item arquivo: "   +arquivo   + "\n"+
			            " Item screen: "    +screen    + "\n");
	 
	}
	
	public void TirarPrint() {
		String screenshotArquivo = "C:/EvidenciaSelenium/" + Generetor.dataHoraParaArquivo() + ".png";
		Screenshot.TirarEvidencia(navegador, screenshotArquivo);
	}
 
}
