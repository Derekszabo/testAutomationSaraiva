package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.CadastroLogic;
import br.com.saraiva.test.logic.HomeLogic;
import br.com.saraiva.test.steps.support.Context;
import br.com.saraiva.test.yaml.model.MassaYaml;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {

	CadastroLogic cad;
	HomeLogic home;
	private MassaYaml massa;

	public CadastroSteps() {
		cad = new CadastroLogic();
		home = new HomeLogic();
		massa = (MassaYaml) Context.testData();
	}

	@Quando("eu clico no botão de cadastrar novo cliente")
	public void eu_clico_no_botão_de_cadastrar_novo_cliente() {
		cad.clicaCadastrar();
	}

	@Quando("entro os dados de cadastro de cliente")
	public void entro_os_dados_de_cadastro_de_cliente() {
		cad.entraNome(massa.getNome());
		cad.entraSobrenome(massa.getSobrenome());
		cad.entraEmail(massa.getEmail());
		cad.entraSenha(massa.getSenha());
		cad.entraSenhaNovamente(massa.getSenha());
		cad.entraCPF(massa.getCpf());
		cad.selecionaSexo(massa.getSexo());
		cad.entraDataNascimento(massa.getDataNascimento());
		cad.entraCelular(massa.getTelefone());
		cad.entraCEP(massa.getCEP());
		cad.entraNumero(massa.getNumeroCasa());
		cad.entraTelefone(massa.getTelefone());
	}

	@Quando("entro os dados incompletos na página")
	public void entro_os_dados_incompletos_na_página() {
		cad.entraSobrenome(massa.getSobrenome());
	}

	@Quando("entro os dados de cadastro de cliente ja cadastrado")
	public void entro_os_dados_de_cadastro_de_cliente_ja_cadastrado() {
		entro_os_dados_de_cadastro_de_cliente();
	}

	@Dado("entre na area de cadastro de cliente")
	public void entre_na_area_de_cadastro_de_cliente() {
		home.clickLogin();
		home.clickBtnEntrarOuCadastrar();
		home.mudaParaJanela();
	}

	@Quando("submeto o cadastro")
	public void submeto_o_cadastro() {
		cad.submit();
	}

	@Então("valido o cadastro de cliente com sucesso")
	public void valido_o_cadastro_de_cliente_com_sucesso() {
		cad.validaCadastro();
	}

	@Então("valido as cores da página")
	public void valido_as_cores_da_página() {
		cad.validaCores();
	}

	@Então("valido os asteriscos vermelhos em campos obrigatórios")
	public void valido_os_asteriscos_vermelhos_em_campos_obrigatórios() {
		cad.submit();
		cad.validaAsterisco();
	}

	@Então("valido o radio button de receber ou não ofertas")
	public void valido_o_radio_button_de_receber_ou_não_ofertas() {
		cad.verificaAtributo("radio");
		cad.validaRadio();
	}

	@Então("valido a mensagem de erro apresentada na tela")
	public void valido_a_mensagem_de_erro_apresentada_na_tela() {
		cad.validaMensagemErro();
	}

	@Então("valido os campos obrigatórios com escritas em vermelho abaixo")
	public void valido_os_campos_obrigatórios_com_escritas_em_vermelho_abaixo() {
		cad.validaLabelVermelha();
	}

	@Então("valido o checkbox de receber ofertas")
	public void valido_o_checkbox_de_receber_ofertas() {
		cad.verificaAtributo("checkbox");
		cad.validaCheckBox();
	}

	@Então("valido os a grafia correta do campo de CPF")
	public void valido_os_a_grafia_correta_do_campo_de_CPF() {
		cad.validaErroGrafiaLabelErroCPF();
	}

}
