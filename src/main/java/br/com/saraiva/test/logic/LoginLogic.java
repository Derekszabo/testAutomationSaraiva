package br.com.saraiva.test.logic;

import static br.com.saraiva.test.steps.support.Context.web;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.LoginPage;

public class LoginLogic {

	private static final String PRETO_REF = "(255, 255, 255, 1)";
	private static final String AMARELO_REF = "(255, 221, 0, 1)";
	public static final String RADIO_VALUE = "radio";
	public static final String CHECKBOX_VALUE = "checkbox";
	public static final String VERMELHO_REF = "(255, 77, 85, 1)";
	LoginPage login;
	String inputType;

	public LoginLogic() {
		login = PageMaker.getInstance(LoginPage.class, web().getWebDriver());
	}

	public void validaCores() {
		web().waitForElementToDissapear(login.getImgLoadScreen(), 10);
		web().waitForElementToBeDisplayed(login.getHeader());
		String colorHeader = login.getHeader().getCssValue("background-color");
		String colorLink = login.getBtnHeader().getCssValue("color");

		if (colorHeader.contains(AMARELO_REF) && colorLink.contains(PRETO_REF)) {
			web().validate(true);
		} else {
			web().failTest();
		}
	}

	public void entraNome(String nome) {
		web().insertText(login.getFldNome(), nome);
	}

	public void entraSobrenome(String sobrenome) {
		web().insertText(login.getFldSobrenome(), sobrenome);
	}

	public void entraEmail(String email) {
		web().insertText(login.getFldEmail(), email);
	}

	public void entraSenha(String senha) {
		web().insertText(login.getFldSenha(), senha);
	}

	public void entraSenhaNovamente(String senha) {
		web().insertText(login.getFldConfirmaSenha(), senha);
	}

	public void entraCPF(String cpf) {
		web().insertText(login.getFldCPF(), cpf);
	}

	public void selecionaSexo(String sexo) {
		verificaSexo(sexo.toUpperCase());
	}

	private void verificaSexo(String sexo) {
		switch (sexo) {
		case ("MASCULINO"):
			web().click(login.getRbMasculino());
			break;

		case ("M"):
			web().click(login.getRbMasculino());
			break;

		case "FEMININO":
			web().click(login.getRbFeminino());
			break;

		case "F":
			web().click(login.getRbFeminino());
			break;

		default:
			throw new RuntimeException("Opção inválida");
		}
	}

	public void entraDataNascimento(String dataNascimento) {
		web().insertText(login.getFldDataNascimento(), dataNascimento);

	}

	public void entraCelular(String telefone) {
		web().insertText(login.getFldCelular(), telefone);
	}

	public void entraCEP(String cep) {
		web().insertText(login.getFldCEP(), cep);
		web().sendTab(login.getFldCEP());
	}

	public void entraNumero(String numeroCasa) {
		web().insertText(login.getFldNumeroCasa(), numeroCasa);
	}

	public void submit() {
		web().click(login.getBtnFinalizarCadastro());
	}

	public void clicaCadastrar() {
		web().click(login.getBtnCadastrar());
	}

	public void entraTelefone(String telefone) {
		web().insertText(login.getFldTelefone(), telefone);

	}

	public void validaCadastro() {
		web().validate(login.getPopValidacao());
	}

	public void validaMensagemErro() {
		web().validate(login.getMsgErroCadastro());

	}

	public void validaAsterisco() {
		web().validate(login.getLblAsterisco());
	}

	public void verificaAtributo(String atributo) {
		this.inputType = login.getChkOfertas().getAttribute("type");
		System.out.println("O atributo do elemento é: " + inputType);
	}

	public void validaRadio() {
		if (this.inputType.equals(RADIO_VALUE)) {
			web().validate(true);
		} else {
			web().failTest();
		}
	}

	public void validaCheckBox() {
		if (this.inputType.equals(CHECKBOX_VALUE)) {
			web().validate(true);
		}

	}

	public void validaLabelVermelha() {
		String lblNome = login.getLblErroNome().getCssValue("color");
		if (lblNome.contains(VERMELHO_REF)) {
			web().validate(true);
		} else {
			web().failTest();
		}

	}

	public void validaErroGrafiaLabelErroCPF() {
		String label = login.getLblErroCPFErrado().getText();
		if (label.equals("Informe um CPF válido")) {
			web().validate(true);
		} else {
			web().failTest();
		}
	}

	public void entraEmailLogin(String email) {
		web().insertText(login.getFldEmailLogin(), email);
	}

	public void entraSenhaLogin(String senha) {
		web().insertText(login.getFldSenhaLogin(), senha);

	}

	public void clicaEntrar() {
		web().click(login.getBtnEntrar());
	}

	public void mudaJanela() {
		web().switchToWindow(0);
	}
}
