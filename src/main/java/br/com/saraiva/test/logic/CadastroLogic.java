package br.com.saraiva.test.logic;

import static br.com.saraiva.test.steps.support.Context.web;

import br.com.saraiva.core.webdriver.PageMaker;
import br.com.saraiva.test.pages.CadastroPage;

public class CadastroLogic {

	private static final String PRETO_REF = "(255, 255, 255, 1)";
	private static final String AMARELO_REF = "(255, 221, 0, 1)";
	public static final String RADIO_VALUE = "radio";
	public static final String CHECKBOX_VALUE = "checkbox";
	public static final String VERMELHO_REF = "(255, 77, 85, 1)";
	private boolean rightColors = false;
	boolean atributoCorreto = false;
	CadastroPage cad;
	String inputType;

	public CadastroLogic() {
		cad = PageMaker.getInstance(CadastroPage.class, web().getWebDriver());
	}

	public void validaCores() {
		web().waitForElementToDissapear(cad.getImgLoadScreen(), 10);
		web().waitForElementToBeDisplayed(cad.getHeader());
		String colorHeader = cad.getHeader().getCssValue("background-color");
		String colorLink = cad.getBtnHeader().getCssValue("color");

		if (colorHeader.contains(AMARELO_REF) && colorLink.contains(PRETO_REF)) {
			web().validate(true);
		} else {
			web().failTest();
		}
	}

	public void entraNome(String nome) {
		web().insertText(cad.getFldNome(), nome);
	}

	public void entraSobrenome(String sobrenome) {
		web().insertText(cad.getFldSobrenome(), sobrenome);
	}

	public void entraEmail(String email) {
		web().insertText(cad.getFldEmail(), email);
	}

	public void entraSenha(String senha) {
		web().insertText(cad.getFldSenha(), senha);
	}

	public void entraSenhaNovamente(String senha) {
		web().insertText(cad.getFldConfirmaSenha(), senha);
	}

	public void entraCPF(String cpf) {
		web().insertText(cad.getFldCPF(), cpf);
	}

	public void selecionaSexo(String sexo) {
		verificaSexo(sexo.toUpperCase());
	}

	private void verificaSexo(String sexo) {
		switch (sexo) {
		case ("MASCULINO"):
			web().click(cad.getRbMasculino());
			break;

		case ("M"):
			web().click(cad.getRbMasculino());
			break;

		case "FEMININO":
			web().click(cad.getRbFeminino());
			break;

		case "F":
			web().click(cad.getRbFeminino());
			break;

		default:
			throw new RuntimeException("Opção inválida");
		}
	}

	public void entraDataNascimento(String dataNascimento) {
		web().insertText(cad.getFldDataNascimento(), dataNascimento);

	}

	public void entraCelular(String telefone) {
		web().insertText(cad.getFldCelular(), telefone);
	}

	public void entraCEP(String cep) {
		web().insertText(cad.getFldCEP(), cep);
		web().sendTab(cad.getFldCEP());
	}

	public void entraNumero(String numeroCasa) {
		web().insertText(cad.getFldNumeroCasa(), numeroCasa);
	}

	public void submit() {
		web().click(cad.getBtnFinalizarCadastro());
	}

	public void clicaCadastrar() {
		web().click(cad.getBtnCadastrar());
	}

	public void entraTelefone(String telefone) {
		web().insertText(cad.getFldTelefone(), telefone);

	}

	public void validaCadastro() {
		web().validate(cad.getPopValidacao());
	}

	public void validaMensagemErro() {
		web().validate(cad.getMsgErroCadastro());

	}

	public void validaAsterisco() {
		web().validate(cad.getLblAsterisco());
	}

	public void verificaAtributo(String atributo) {
		this.inputType = cad.getChkOfertas().getAttribute("type");
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
		String lblNome = cad.getLblErroNome().getCssValue("color");
		if (lblNome.contains(VERMELHO_REF)) {
			web().validate(true);
		} else {
			web().failTest();
		}

	}

	public void validaErroGrafiaLabelErroCPF() {
		String label = cad.getLblErroCPFErrado().getText();
		if (label.equals("Informe um CPF válido")) {
			web().validate(true);
		} else {
			web().failTest();
		}
	}
}
