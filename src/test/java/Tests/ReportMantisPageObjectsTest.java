package Tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Pages.BugReport;
import Pages.LoginSite;
import Pages.PageUser;
import Suporte.Web;
import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;
//import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths={"loginSite.csv","CadastrarUmBugNoSite.csv"},appendData=true)
public class ReportMantisPageObjectsTest {

	static WebDriver navegador;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		navegador = Web.createMarionete();
	}

	@After
	public void tearDown() throws Exception {
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		if (navegador != null) {
//            navegador.quit();
//        }
	}
	
	@Test
	public void LogarEvalidarUsuario(
			@Param(name = "username") String user,
			@Param(name = "password") String pass) {
		new LoginSite(navegador)
		.varLogin(user)
		.varPassword(pass)
		.varSeguraca()
		.clicarLogar();
		assertEquals(new PageUser(navegador).validaUsuario(), "william.melquiades");
	}
	
	@Test 
	public void CadastrarUmBugNoSite( 						
			@Param(name = "category_id")        String tipo1, 
			@Param(name = "reproducibility")    String tipo2,
			@Param(name = "severity")           String tipo3, 
			@Param(name = "priority")           String tipo4,
			@Param(name = "profile_id")         String tipo5, 
			@Param(name = "platform")  		    String tipo6,
			@Param(name = "os") 			    String tipo7, 
			@Param(name = "os_build")           String tipo8,
			@Param(name = "handler_id")         String tipo9, 
			@Param(name = "summary") 		    String tipo10,
			@Param(name = "description")        String tipo11, 
			@Param(name = "steps_to_reproduce") String tipo12,
			@Param(name = "additional_info")    String tipo13
			) throws Exception{
				new PageUser(navegador).clicarnoReport();
				new BugReport(navegador)
				.varTipo1(tipo1)
				.varTipo2(tipo2)
				.varTipo3(tipo3)
				.varTipo4(tipo4)
				.varTipo5(tipo5)
				.varTipo6(tipo6)
				.varTipo7(tipo7)
				.varTipo8(tipo8)
				.varTipo9(tipo9)
				.varTipo10(tipo10)
				.varTipo11(tipo11)
				.varTipo12(tipo12)
				.varTipo13(tipo13)
				.acoesInternnasReport()
				.submeterBug();
//				
//				.typeReporte(		
//				"[All Projects] General", "sometimes", "trivial", "urgent", "Desktop Windows 10", 
//				"Linux", "Linux Kali", "Linux Kali 2018", "william.melquiades", 
//				"Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum", "Lorem Ipsum"
				
	}
	

}
