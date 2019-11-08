package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

	@After
	public void end() {
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