package Tests;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Pages.BugReport;
import Pages.LoginSite;
import Pages.PageUser;
import Suporte.Web;
//import io.github.bonigarcia.wdm.WebDriverManager;

//@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "CadastrarUmBugNoSite.csv")
public class ReportMantisPageObjectsTest {

	static WebDriver navegador;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		navegador = Web.createMarionete();
	}

	@After
	public void tearDown() throws Exception {
		// navegador.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		// navegador.close();
//		if (navegador != null) {
//            navegador.quit();
//        }
	}
	
	@Test
	public void LogarEvalidarUsuario() {
		new LoginSite(navegador)
		.varLogin("william.melquiades")
		.varPassword("@01!01@")
		.varSeguraca().clicarLogar();
		assertEquals(new PageUser(navegador).validaUsuario(), "william.melquiades");
	}
	
	
	@Test 
	public void CadastrarUmBugNoSite(
//			@Param(name="category_id")String tipo1,
//			@Param(name="reproducibility")String tipo2,
//			@Param(name="severity")String tipo3,
//			@Param(name="priority")String tipo4,
//			@Param(name="profile_id")String tipo5,
//			@Param(name="platform")String tipo6,
//			@Param(name="os")String tipo7,
//			@Param(name="os_build")String tipo8,
//			@Param(name="handler_id")String tipo9,
//			@Param(name="summary")String tipo10,
//			@Param(name="description")String tipo11,
//			@Param(name="steps_to_reproduce")String tipo12,
//			@Param(name="additional_info")String tipo13
			) throws Exception{
				new PageUser(navegador)
				.clicarnoReport();
				//new BugReport(navegador)
				//.typeReporte(tipo1, tipo2, tipo3,tipo4, tipo5, tipo6, tipo7,tipo8,tipo9,tipo10,tipo11,tipo12,tipo13);	

				//		xx.clicarnoReport().typeReporte("[All Projects] General", "sometimes", "trivial", "urgent", "Desktop Windows 10", 
//				"Linux", "Linux Kali", "Linux Kali 2018", "william.melquiades", 
//				"Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum");
		
	}

}
