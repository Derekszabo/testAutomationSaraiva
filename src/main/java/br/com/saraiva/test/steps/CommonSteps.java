package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.HomeLogic;
import br.com.saraiva.test.logic.LoginLogic;
import br.com.saraiva.test.steps.support.Context;
import br.com.saraiva.test.yaml.model.MassaYaml;
import io.cucumber.java.pt.Dado;

public class CommonSteps {

	HomeLogic home;
	LoginLogic login;
	MassaYaml massa;

	public CommonSteps() {
		home = new HomeLogic();
		login = new LoginLogic();
		massa = (MassaYaml) Context.testData();
	}

	@Dado("que o usuario entre no site")
	public void que_o_usuario_entre_no_site() {
		home.accessHomePage();
	}

	@Dado("entre na area de cadastro de cliente")
	public void entre_na_area_de_cadastro_de_cliente() {
		home.clickLogin();
		home.clickBtnEntrarOuCadastrar();
		home.mudaParaJanela();
	}

	@Dado("efetue login")
	public void efetue_login() {
		login.entraEmailLogin(massa.getEmail());
		login.entraSenhaLogin(massa.getSenha());
		login.clicaEntrar();
		login.mudaJanela();
	}
}
