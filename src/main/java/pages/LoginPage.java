package pages;

import org.openqa.selenium.By;

import core.DriverFactory;

public class LoginPage {

	public LoginPage () {}

	By writeEmail = By.id("email");
	By writePassword = By.id("senha");
	By buttonLogin = By.className("btn-primary");
	By msgSuccess = By.className("alert-success");
	By msgError = By.className("alert-danger");


	public void setEmail(String email) {
		DriverFactory.getDriver().findElement(writeEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		DriverFactory.getDriver().findElement(writePassword).sendKeys(password);
	}

	public void login() {
		DriverFactory.getDriver().findElement(buttonLogin).click();
	}

	public String getMessageSuccess() {
		return DriverFactory.getDriver().findElement(msgSuccess).getText();
	}

	public String getMessageError() {
		return DriverFactory.getDriver().findElement(msgError).getText();
	}

	public void loginSuccess(String email, String password) {
		DriverFactory.getDriver().findElement(writeEmail).sendKeys(email);
		DriverFactory.getDriver().findElement(writePassword).sendKeys(password);
		DriverFactory.getDriver().findElement(buttonLogin).click();
	}
}