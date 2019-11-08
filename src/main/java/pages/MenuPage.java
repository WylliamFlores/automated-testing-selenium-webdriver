package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class MenuPage {	

	public MenuPage () {}

	By account = By.xpath("//*[@class='nav navbar-nav']//li[@class='dropdown']");
	By addAccount = By.xpath("//*[@class='nav navbar-nav']//li//a[contains(@href,'/addConta')]");
	By listAccount = By.xpath("//*[@class='nav navbar-nav']//li//a[contains(@href,'/contas')]");
	By movement = By.xpath("//*[@class='nav navbar-nav']//li//a[contains(@href,'/movimentacao')]");
	By monthlyResume = By.xpath("//*[@class='nav navbar-nav']//li//a[contains(@href,'/extrato')]");

	public void clickAddAccount() {
		DriverFactory.getDriver().findElement(account).click();
		DriverFactory.getDriver().findElement(addAccount).click();
	}

	public void clickListAccount() {
		DriverFactory.getDriver().findElement(account).click();
		DriverFactory.getDriver().findElement(listAccount).click();
	}

	public void clickMovement() {
		DriverFactory.getDriver().findElement(movement).click();
	}

	public void clickMonthlyResume() {
		DriverFactory.getDriver().findElement(monthlyResume).click();	
	}
}