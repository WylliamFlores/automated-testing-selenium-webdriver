package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	//private static WebDriver browser;

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue(){
			return initDriver();
		}
	};

	private DriverFactory() {}

	public static WebDriver getDriver(){
		return threadDriver.get();
	}

	public static WebDriver initDriver() {
		WebDriver browser = null;
		if (browser == null) {
			browser = new FirefoxDriver();
		}
		browser.manage().window().setSize(new Dimension(1200, 765));
		return browser;
	}

	public static void killDriver() {
		WebDriver browser = getDriver();
		if (browser != null) {
			browser.quit();
			browser = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}