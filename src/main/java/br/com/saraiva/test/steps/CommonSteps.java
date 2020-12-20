package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.HomeLogic;
import io.cucumber.java.pt.Dado;

public class CommonSteps {

	HomeLogic home;

	public CommonSteps() {
		home = new HomeLogic();
	}

	@Dado("que o usuario entre no site")
	public void que_o_usuario_entre_no_site() {
		home.accessHomePage();
	}
}
