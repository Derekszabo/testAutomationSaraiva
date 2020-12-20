package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.HomeLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class TesteSteps {

	HomeLogic home;

	public TesteSteps() {
		home = new HomeLogic();
	}

	@Dado("que eu abro o site da saraiva")
	public void que_eu_abro_o_site_da_saraiva() {
		home.accessHomePage();
	}

	@Então("valido que estou nele")
	public void valido_que_estou_nele() {
		System.out.println("AAAAAAAAAAAAAA");
	}

}
