package br.com.saraiva.test.logic;

import static br.com.saraiva.test.pages.ProdutoPage.getLivrosdigitaislink;
import static br.com.saraiva.test.steps.support.Context.web;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.ProdutoPage;

public class ProdutoLogic {

	ProdutoPage prod;

	public ProdutoLogic() {
		prod = PageMaker.getInstance(ProdutoPage.class, web().getWebDriver());
	}

	public void clicaPrimeiroLivroFisico() {
		web().click(prod.getImgPrimeiroItemBuscaLivroFisico());
	}

	public void buscaLivroDigital() {
		web().navigateToUrl(getLivrosdigitaislink());
	}

	public void adicionaNoCarrinho(String midia) {
		midia = midia.toUpperCase();
		selecionaFisicoOuDigital(midia);
	}

	private void selecionaFisicoOuDigital(String midia) {
		switch (midia) {
		case "FISICO":
			web().click(prod.getBtnComprarLivroFisico());
			break;
		case "DIGITAL":
			web().click(prod.getBtnComprarLivroDigital());
			break;

		default:
			throw new RuntimeException("Opção inválida");
		}
	}

	public void clicaPrimeiroLivroDigital() {
		web().click(prod.getImgPrimeiroItemBuscaLivroDigital());
	}

	public void validaAbaLivroDigital() {
		web().validate(prod.getLinkAbaProdutoDigital());
	}

	public void validaAbaLivroFisico() {
		web().validate(prod.getLinkAbaProdutoFisico());
	}

	public void validaDescricao() {
		web().validate(prod.getTxtDescricao());
	}

	public void validaCaracteristicas() {
		web().validate(prod.getTxtCaracteristicas());
	}
}
