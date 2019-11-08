package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.DriverFactory;

public class MovementPage {

	public MovementPage() {}

	By selectMovement = By.id("tipo");
	By dateMovement = By.id("data_transacao");
	By datePay = By.id("data_pagamento");
	By writeDescription = By.id("descricao");
	By writeInterested = By.id("interessado");
	By writeValue = By.id("valor");
	By selectAccount = By.id("conta");
	By radioPaid = By.id("status_pago");
	By buttonSave = By.className("btn-primary");
	By msgSuccess = By.className("alert-success");
	By msgError = By.xpath("//div[@class='alert alert-danger']//li");
	By verifyMovement = By.xpath("//*[@id='tabelaExtrato']//tbody//tr//td[.='test movement']/..//td[.='Conta para extrato']/../td[.='-500.00']");	
	By deleteMovement = By.xpath("//*[@id='tabelaExtrato']//td[.='Movimentacao para exclusao']/..//span[@class='glyphicon glyphicon-remove-circle']");


	public void selectMovement(String valor) {
		new Select(DriverFactory.getDriver().findElement(selectMovement)).selectByVisibleText(valor);
	}

	public void setDateMovement(String data) {
		DriverFactory.getDriver().findElement(dateMovement).sendKeys(data);
	}

	public void setDatePay(String data) {
		DriverFactory.getDriver().findElement(datePay).sendKeys(data);
	}

	public void setDescription(String description) {
		DriverFactory.getDriver().findElement(writeDescription).sendKeys(description);
	}

	public void setInterested(String interested) {
		DriverFactory.getDriver().findElement(writeInterested).sendKeys(interested);
	}

	public void setValue(String value) {
		DriverFactory.getDriver().findElement(writeValue).sendKeys(value);
	}

	public void selectAccount (String account) {
		new Select(DriverFactory.getDriver().findElement(selectAccount)).selectByVisibleText(account);
	}

	public void setRadioPaid() {
		DriverFactory.getDriver().findElement(radioPaid).click();
	}

	public void clickSave() {
		DriverFactory.getDriver().findElement(buttonSave).click();
	}

	public String getMessageSuccess() {
		return DriverFactory.getDriver().findElement(msgSuccess).getText();
	}

	public String getVerifyMovement () {
		return DriverFactory.getDriver().findElement(verifyMovement).getText();
	}

	public List<String> getErrors(){
		List<WebElement> errors = DriverFactory.getDriver().findElements(msgError);
		List<String> retorno = new ArrayList<String>();
		for(WebElement error: errors) {
			retorno.add(error.getText());
		}
		return retorno;
	}
	public void clicDeleteMovement() {
		DriverFactory.getDriver().findElement(deleteMovement).click();
	}
}