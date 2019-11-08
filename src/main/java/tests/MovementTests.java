package tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.MenuPage;
import pages.MovementPage;
import utils.DataUtils;

public class MovementTests extends BaseTest {

	MenuPage menuPage = new MenuPage();
	MovementPage movementPage = new MovementPage();

	@Test
	public void createMovement() {
		menuPage.clickMovement();
		movementPage.selectMovement("Despesa");
		movementPage.setDateMovement(DataUtils.obterDataFormatada(new Date()));
		movementPage.setDatePay(DataUtils.obterDataFormatada(new Date()));
		movementPage.setDescription("test movement");
		movementPage.setInterested("nobody");
		movementPage.setValue("500");
		movementPage.selectAccount("Conta para extrato");
		movementPage.setRadioPaid();
		movementPage.clickSave();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movementPage.getMessageSuccess());
		menuPage.clickMonthlyResume();
		Assert.assertEquals("-500.00", movementPage.getVerifyMovement());
	}

	@Test
	public void movementRequiredFields() {
		menuPage.clickMovement();
		movementPage.clickSave();
		List<String> errors = movementPage.getErrors();
		Assert.assertTrue(errors.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
				"Descrição é obrigatório", "Interessado é obrigatório",
				"Valor é obrigatório", "Valor deve ser um número")));
		Assert.assertEquals(6, errors.size());
	}

	@Test
	public void deleteMovement() {
		menuPage.clickMonthlyResume();
		movementPage.clicDeleteMovement();
		Assert.assertEquals("Movimentação removida com sucesso!", movementPage.getMessageSuccess());		
	}	
}