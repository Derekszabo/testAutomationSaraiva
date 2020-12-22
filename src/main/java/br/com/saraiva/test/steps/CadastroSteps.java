package br.com.saraiva.test.steps;

import br.com.saraiva.test.logic.HomeLogic;
import br.com.saraiva.test.logic.LoginLogic;
import br.com.saraiva.test.steps.support.Context;
import br.com.saraiva.test.yaml.model.MassaYaml;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {

	LoginLogic login;
	HomeLogic home;
	private MassaYaml massa;

	public CadastroSteps() {
		login = new LoginLogic();
		home = new HomeLogic();
		massa = (MassaYaml) Context.testData();
	}

	@Quando("eu clico no botão de cadastrar novo cliente")
	public void eu_clico_no_botão_de_loginastrar_novo_cliente() {
		login.clicaCadastrar();
	}

	@Quando("entro os dados de cadastro de cliente")
	public void entro_os_dados_de_cadastro_de_cliente() {
		login.entraNome(massa.getNome());
		login.entraSobrenome(massa.getSobrenome());
		login.entraEmail(massa.getEmail());
		login.entraSenha(massa.getSenha());
		login.entraSenhaNovamente(massa.getSenha());
		login.entraCPF(massa.getCpf());
		login.selecionaSexo(massa.getSexo());
		login.entraDataNascimento(massa.getDataNascimento());
		login.entraCelular(massa.getTelefone());
		login.entraCEP(massa.getCEP());
		login.entraNumero(massa.getNumeroCasa());
		login.entraTelefone(massa.getTelefone());
	}

	@Quando("entro os dados incompletos na página")
	public void entro_os_dados_incompletos_na_página() {
		login.entraSobrenome(massa.getSobrenome());
	}

	@Quando("entro os dados de cadastro de cliente ja cadastrado")
	public void entro_os_dados_de_cadastro_de_cliente_ja_cadastrado() {
		entro_os_dados_de_cadastro_de_cliente();
	}

	@Quando("submeto o cadastro")
	public void submeto_o_cadastro() {
		login.submit();
	}

	@Então("valido o cadastro de cliente com sucesso")
	public void valido_o_cadastro_de_cliente_com_sucesso() {
		login.validaCadastro();
	}

	@Então("valido as cores da página")
	public void valido_as_cores_da_página() {
		login.validaCores();
	}

	@Então("valido os asteriscos vermelhos em campos obrigatórios")
	public void valido_os_asteriscos_vermelhos_em_campos_obrigatórios() {
		login.submit();
		login.validaAsterisco();
	}

	@Então("valido o radio button de receber ou não ofertas")
	public void valido_o_radio_button_de_receber_ou_não_ofertas() {
		login.verificaAtributo("radio");
		login.validaRadio();
	}

	@Então("valido a mensagem de erro apresentada na tela")
	public void valido_a_mensagem_de_erro_apresentada_na_tela() {
		login.validaMensagemErro();
	}

	@Então("valido os campos obrigatórios com escritas em vermelho abaixo")
	public void valido_os_campos_obrigatórios_com_escritas_em_vermelho_abaixo() {
		login.validaLabelVermelha();
	}

	@Então("valido o checkbox de receber ofertas")
	public void valido_o_checkbox_de_receber_ofertas() {
		login.verificaAtributo("checkbox");
		login.validaCheckBox();
	}

	@Então("valido os a grafia correta do campo de CPF")
	public void valido_os_a_grafia_correta_do_campo_de_CPF() {
		login.validaErroGrafiaLabelErroCPF();
	}

}
