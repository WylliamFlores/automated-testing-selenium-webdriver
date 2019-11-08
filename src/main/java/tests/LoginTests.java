package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DriverFactory;
import pages.LoginPage;

public class LoginTests {

	private LoginPage page;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Informatica\\eclipse-workspace\\driver\\geckodriver.exe");
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		page = new LoginPage();
	}

	@Rule
	public TestName testName = new TestName();

	@After
	public void end()throws IOException{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File archive = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archive, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));

		DriverFactory.killDriver();
	}

	@Test
	public void logInSucces() {
		page.setEmail("wylliam.mflores@gmail.com");
		page.setPassword("0123456789");
		page.login();
		Assert.assertEquals("Bem vindo, Wylliam Flores!", page.getMessageSuccess());
	}

	@Test
	public void logInEmailRequired() {
		page.setPassword("0123456789");
		page.login();
		Assert.assertEquals("Email é um campo obrigatório", page.getMessageError());
	}

	@Test
	public void logInPasswordRequired() {
		page.setEmail("wylliam.mflores@gmail.com");
		page.login();
		Assert.assertEquals("Senha é um campo obrigatório", page.getMessageError());
	}

	@Test
	public void logInInvalid() {
		page.setEmail("wylliam.mflores@gmail.com");
		page.setPassword("invalid");
		page.login();
		Assert.assertEquals("Problemas com o login do usuário", page.getMessageError());
	}
}