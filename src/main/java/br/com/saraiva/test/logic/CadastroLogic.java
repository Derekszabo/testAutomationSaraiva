package br.com.saraiva.test.logic;

import static br.com.saraiva.test.steps.support.Context.web;
import static org.testng.Assert.assertTrue;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.CadastroPage;

public class CadastroLogic {

	CadastroPage cad;
	private boolean rightColors = false;

	public CadastroLogic() {
		cad = PageMaker.getInstance(CadastroPage.class, web().getWebDriver());
	}

	public void validaCores() {
		web().waitForElementToDissapear(cad.getImgLoadScreen(), 10);
		web().waitForElementToBeDisplayed(cad.getHeader());
		String colorHeader = cad.getHeader().getCssValue("background-color");
		String colorLink = cad.getBtnHeader().getCssValue("color");

		if (colorHeader.contains("(255, 221, 0, 1)") && colorLink.contains("(255, 255, 255, 1)")) {
			rightColors = true;
		}
		assertTrue(rightColors);
	}
}
