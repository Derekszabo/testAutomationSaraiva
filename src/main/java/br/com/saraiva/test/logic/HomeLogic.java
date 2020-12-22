package br.com.saraiva.test.logic;

import static br.com.saraiva.test.pages.HomePage.getHomepagelink;
import static br.com.saraiva.test.steps.support.Context.web;

import org.openqa.selenium.Keys;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.HomePage;

public class HomeLogic {
	HomePage home;

	public HomeLogic() {
		home = PageMaker.getInstance(HomePage.class, web().getWebDriver());
	}

	public void accessHomePage() {

		web().navigateToUrl(getHomepagelink());
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

	public void buscaProduto(String livro) {
		web().insertText(home.getFldBusca(), livro);
		web().insertKey(home.getFldBusca(), Keys.ENTER);
	}

}
