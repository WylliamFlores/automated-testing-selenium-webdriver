package core;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginPage;

public class BaseTest {

	private LoginPage page = new LoginPage();

	@Before
	public void initialize() {		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Informatica\\eclipse-workspace\\driver\\geckodriver.exe");
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		page.loginSuccess("wylliam.mflores@gmail.com", "0123456789");
		DriverFactory.getDriver().findElement(By.linkText("reset")).click();
	}

	@Rule
	public TestName testName = new TestName();

	@After
	public void end() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File archive = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(archive, new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".jpg"));

		DriverFactory.killDriver();
	}
}