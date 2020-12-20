package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.CadastroLogic;
import br.com.saraiva.test.logic.HomeLogic;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {

	CadastroLogic cad;
	HomeLogic home;

	public CadastroSteps() {
		cad = new CadastroLogic();
		home = new HomeLogic();
	}

	@Dado("entre na area de cadastro de cliente")
	public void entre_na_area_de_cadastro_de_cliente() {
		home.clickLogin();
		home.clickBtnEntrarOuCadastrar();
		home.mudaParaJanela();
	}

	@Quando("eu entro os dados de cadastro de cliente")
	public void eu_entro_os_dados_de_cadastro_de_cliente() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Quando("submeto o cadastro")
	public void submeto_o_cadastro() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Então("valido o cadastro de cliente com sucesso")
	public void valido_o_cadastro_de_cliente_com_sucesso() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Então("valido as cores da página")
	public void valido_as_cores_da_página() {
		cad.validaCores();
	}

	@Quando("eu entro os dados incompletos na página")
	public void eu_entro_os_dados_incompletos_na_página() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Então("valido os asteriscos vermelhos em campos obrigatórios")
	public void valido_os_asteriscos_vermelhos_em_campos_obrigatórios() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Então("valido o radio button de receber ou não ofertas")
	public void valido_o_radio_button_de_receber_ou_não_ofertas() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}
