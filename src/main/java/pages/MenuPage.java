package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class MenuPage {
	
	public MenuPage () {}
	
	By account = By.className("dropdown-toggle");
	By addAccount = By.linkText("/addConta");
	By listAccount = By.linkText("/contas");
	
	public void clickAccount() {
		DriverFactory.getDriver().findElement(account).click();
	}
	
	public void clickAddAccount() {
		DriverFactory.getDriver().findElement(addAccount).click();
	}
	
	public void clickListAccount() {
		DriverFactory.getDriver().findElement(listAccount).click();
	}
}
