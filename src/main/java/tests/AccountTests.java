package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.MenuPage;


public class AccountTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	AccountPage accountPage = new AccountPage();

	@Test
	public void createAccount() {
		menuPage.clickAddAccount();
		accountPage.setName("Conta Wylliam");
		accountPage.clickSave();
		Assert.assertEquals("Conta adicionada com sucesso!", accountPage.getMessageSuccess());
		Assert.assertEquals("Conta Wylliam", accountPage.getVerifyAccount());
	}

	@Test
	public void accountNameRequired() {
		menuPage.clickAddAccount();
		accountPage.clickSave();
		Assert.assertEquals("Informe o nome da conta", accountPage.getMessageError());
	}

	@Test
	public void accountNameInUse() {
		menuPage.clickAddAccount();
		accountPage.setName("Conta com movimentacao");
		accountPage.clickSave();
		Assert.assertEquals("Já existe uma conta com esse nome!", accountPage.getMessageError());
	}

	@Test
	public void editAccount() {
		menuPage.clickListAccount();
		accountPage.clickEdit();
		accountPage.setName("Conta Alterada");
		accountPage.clickSave();
		Assert.assertEquals("Conta alterada com sucesso!", accountPage.getMessageSuccess());		
	}

	@Test
	public void deleteAccountWithMovement() {
		menuPage.clickListAccount();
		accountPage.clickDeleteUnsuccessful();
		Assert.assertEquals("Conta em uso na movimentações", accountPage.getMessageError());
	}

	@Test
	public void deleteAccount() {
		menuPage.clickListAccount();
		accountPage.clicDeleteSuccessfully();
		Assert.assertEquals("Conta removida com sucesso!", accountPage.getMessageSuccess());
	}
}