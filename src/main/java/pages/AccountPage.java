package pages;

import org.openqa.selenium.By;

import core.DriverFactory;


public class AccountPage {

	public AccountPage() {}

	By writeName = By.id("nome");
	By buttonSave = By.className("btn-primary");
	By msgSuccess = By.className("alert-success");
	By msgError = By.className("alert-danger");
	By verifyAccount = By.xpath("//*[@id='tabelaContas']//td[.='Conta Wylliam']");
	By deleteUnsuccessful = By.xpath("//*[@id='tabelaContas']//td[.='Conta com movimentacao']/..//span[@class='glyphicon glyphicon-remove-circle']");
	By deleteSuccessfully = By.xpath("//*[@id='tabelaContas']//td[.='Conta mesmo nome']/..//span[@class='glyphicon glyphicon-remove-circle']");
	By editAccount = By.xpath("//*[@id='tabelaContas']//td[.='Conta para alterar']/..//span[@class='glyphicon glyphicon-edit']");

	public void setName(String nome) {
		DriverFactory.getDriver().findElement(writeName).clear();
		DriverFactory.getDriver().findElement(writeName).sendKeys(nome);
	}

	public void clickSave() {
		DriverFactory.getDriver().findElement(buttonSave).click();
	}

	public void clickDeleteUnsuccessful() {
		DriverFactory.getDriver().findElement(deleteUnsuccessful).click();
	}

	public void clicDeleteSuccessfully() {
		DriverFactory.getDriver().findElement(deleteSuccessfully).click();
	}

	public void clickEdit() {
		DriverFactory.getDriver().findElement(editAccount).click();
	}

	public String getMessageError() {
		return DriverFactory.getDriver().findElement(msgError).getText();	
	}

	public String getMessageSuccess() {
		return DriverFactory.getDriver().findElement(msgSuccess).getText();
	}

	public String getVerifyAccount () {
		return DriverFactory.getDriver().findElement(verifyAccount).getText();
	}
}