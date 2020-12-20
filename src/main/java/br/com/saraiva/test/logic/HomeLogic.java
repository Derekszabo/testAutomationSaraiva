package br.com.saraiva.test.logic;

import static br.com.saraiva.test.steps.support.Context.web;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.HomePage;

public class HomeLogic {
	HomePage home;
	private static final String HOMEPAGELINK = "https://www.saraiva.com.br/";

	public HomeLogic() {
		home = PageMaker.getInstance(HomePage.class, web().getWebDriver());
	}

	public void accessHomePage() {

		web().navigateToUrl(HOMEPAGELINK);
	}

	public void clickLogin() {
		web().click(home.getBtnLogin());
	}

	public void clickBtnEntrarOuCadastrar() {
		web().click(home.getBtnEntreOuCadastreSe());
	}

	public void mudaParaJanela() {
		web().switchToWindow(1);
	}

}
