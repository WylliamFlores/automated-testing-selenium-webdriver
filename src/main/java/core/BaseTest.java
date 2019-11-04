package core;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

import pages.LoginPage;


public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Before
	public void initialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Informatica\\eclipse-workspace\\driver\\geckodriver.exe");
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		page.loginSuccess("wylliam.mflores@gmail.com", "0123456789");
	}
	
	@After
	public void end() {
		DriverFactory.killDriver();		
	}
}