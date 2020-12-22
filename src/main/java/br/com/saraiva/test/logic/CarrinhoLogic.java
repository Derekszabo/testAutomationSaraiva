package br.com.saraiva.test.logic;

import static br.com.saraiva.test.steps.support.Context.web;

import java.util.List;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.CarrinhoPage;

public class CarrinhoLogic {

	CarrinhoPage car;

	public CarrinhoLogic() {
		car = PageMaker.getInstance(CarrinhoPage.class, web().getWebDriver());
	}

	public void testoIsso() {
		List<String> list = web().readFromElements(car.getTblCarrinho());
		for (int i = 0; i <= list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public void validaErroProdutosCarrinho() {
		// TODO Auto-generated method stub

	}

}
